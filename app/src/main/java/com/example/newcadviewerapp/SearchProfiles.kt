package com.example.newcadviewerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import java.util.*


class SearchProfiles: AppCompatActivity() {

    // creating variable for searchview
    private lateinit var searchView: SearchView
    private lateinit var recyclerSearch:RecyclerView
    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_bar)



        searchView = findViewById<View>(R.id.idSearchView) as SearchView
        recyclerSearch = findViewById<View>(R.id.recyclerviewSearch) as RecyclerView

//options for Recycler view and Data snapshot for custom display
        val options: FirebaseRecyclerOptions<SearchModel> = FirebaseRecyclerOptions.Builder<SearchModel>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("Users"))
            { snapshot:DataSnapshot ->
                val email = snapshot.child("Email Id").getValue(String::class.java)
                val userType = snapshot.child("User Type").getValue(String::class.java)
                val password = snapshot.child("Password").getValue(String::class.java)
                SearchModel(email, userType, password)
            }
            .build()

        adapter = SearchAdapter(options)
        recyclerSearch.adapter = adapter
        recyclerSearch.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL ,false)


        //SearchView start:
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Do nothing when submit button is pressed
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String): Boolean {
                val usersRef = FirebaseDatabase.getInstance().reference.child("Users")
                val firebaseSearchQuery: Query
             val newText1 = newText.lowercase()
             val queri = newText1.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                if (queri.isEmpty()) {
                    firebaseSearchQuery = usersRef
                } else {
                    val searchField = if (queri.contains("@")) {
                        "Email Id"
                    } else {
                        "User Type"
                    }
                    firebaseSearchQuery = usersRef.orderByChild(searchField)
                        .startAt(queri)
                        .endAt(queri + "\uf8ff")
                }
                val options = FirebaseRecyclerOptions.Builder<SearchModel>()
                    .setQuery(firebaseSearchQuery)
                    { snapshot: DataSnapshot ->
                        val email = snapshot.child("Email Id").getValue(String::class.java)
                        val userType = snapshot.child("User Type").getValue(String::class.java)
                        val password = snapshot.child("Password").getValue(String::class.java)
                        SearchModel(email, userType, password)
                    }
                    .build()


                adapter.updateOptions(options)
                adapter.startListening()
                adapter.notifyDataSetChanged()
                 return true
            }
        })



        //searchview end


    }
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }
    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

}



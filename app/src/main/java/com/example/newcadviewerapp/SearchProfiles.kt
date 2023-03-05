package com.example.newcadviewerapp

import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase


class SearchProfiles: AppCompatActivity() {
    lateinit var List: ListView
    // creating variable for searchview
    lateinit var searchView: SearchView
    lateinit var recyclerSearch:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_bar)



        searchView = findViewById(R.id.idSearchView)
        recyclerSearch = findViewById(R.id.recyclerviewSearch)

       recyclerSearch.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL ,false)
        val options: FirebaseRecyclerOptions<SearchModel> = FirebaseRecyclerOptions.Builder<SearchModel>()
            .setQuery(FirebaseDatabase.getInstance().getReference().child("Users"), SearchModel::class.java)
            .build()



    }
}



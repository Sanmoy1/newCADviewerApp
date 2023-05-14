package com.example.newcadviewerapp
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions



class SearchAdapter(options: FirebaseRecyclerOptions<SearchModel>) :FirebaseRecyclerAdapter<SearchModel, SearchAdapter.SearchViewHolder>(options)
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.search_recycler_result,parent,false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int, model: SearchModel) {
        holder.type.setText("User is : " + model.userType)
        holder.email.setText("Email is "+ model.email)
        holder.password.setText(model.password)

    }


  inner class SearchViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var email:TextView
        var type: TextView
        var password:TextView

        init{
        email = itemView.findViewById(R.id.userEmail)
         type = itemView.findViewById(R.id.userType)
        password = itemView.findViewById(R.id.password)
    }


    }

}

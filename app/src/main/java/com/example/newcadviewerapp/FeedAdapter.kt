package com.example.newcadviewerapp


import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth

import com.google.firebase.ktx.Firebase



class FeedAdapter(private val arraylist: ArrayList<FeedModel>) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>()
 {
     //private var arraylist=mutableListOf<FeedModel>()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val createdAt: TextView = itemView.findViewById(R.id.createdAt)
      //  val likeCount: TextView = itemView.findViewById(R.id.likeCount)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
       // val likeButton: ImageButton = itemView.findViewById(R.id.likeButton)
        val postImage :ImageView  = itemView.findViewById(R.id.post_id)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_post,parent,false)
        return PostViewHolder(view)

    }




    override fun getItemCount(): Int {
        return arraylist.size
    }

     @SuppressLint("RestrictedApi")
     override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentFeed = arraylist[position]
         holder.userName.text = currentFeed.createdBy.toString()
         holder.createdAt.text = currentFeed.createdAt.toString()
         holder.postTitle.text = currentFeed.postTitle
         holder.userImage.setImageResource(currentFeed.profileIcon)
         holder.postImage.setImageResource(currentFeed.postImage)



     }
 }







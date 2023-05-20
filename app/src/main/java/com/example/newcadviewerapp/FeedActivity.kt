package com.example.newcadviewerapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class FeedActivity:AppCompatActivity() {
    lateinit var recycler_feed: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_layout)

        recycler_feed.findViewById<View>(R.id.feed_recycler)

    }
}
package com.example.newcadviewerapp

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class FeedActivity:AppCompatActivity() {
    lateinit var recycler_feed: RecyclerView
     lateinit var adapter: FeedAdapter
     lateinit var arrayList: ArrayList<FeedModel>
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_layout)


 //getting current time and date
        val currentTimeMillis = System.currentTimeMillis()

// Create a Date object from the current time
        val date = Date(currentTimeMillis)

// Create a SimpleDateFormat object to format the date
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

// Format the date as a string
        val currentDate = dateFormat.format(date)

// Create a SimpleDateFormat object to format the time
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

// Format the time as a string
        val currentTime = timeFormat.format(date)

// Combine the date and time strings
        val currentDateTime = "$currentDate $currentTime"


        arrayList = ArrayList() //need to initialize arraylist
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed)) //adding manually
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"Please Review my Art",R.drawable.profilepicture,R.drawable.image_for_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))












        recycler_feed = findViewById<View>(R.id.feed_recycler) as RecyclerView //connect recycler view to layout
        adapter = FeedAdapter(arrayList) //Initialize adapter
        recycler_feed.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true) //layout for Recycler
        recycler_feed.adapter = adapter //connecting adapter to recycler.

    }
}
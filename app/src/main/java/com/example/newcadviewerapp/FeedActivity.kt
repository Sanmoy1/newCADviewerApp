package com.example.newcadviewerapp

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class FeedActivity:AppCompatActivity() {
    lateinit var recycler_feed: RecyclerView
     lateinit var adapter: FeedAdapter
     lateinit var arrayList: ArrayList<FeedModel>
     lateinit var likebutton:ImageButton
     lateinit var likecount:TextView

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

        arrayList.add(FeedModel("Zoro",currentDateTime,"Please Review my Art",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"Post1",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Emma",currentDateTime,"Post2",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Olivia",currentDateTime,"Post3",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Ava",currentDateTime,"Post4",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Sophia",currentDateTime,"Post5",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Charlotte",currentDateTime,"Post6",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Amelia",currentDateTime,"Post7",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Isabella",currentDateTime,"Post8",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Mia",currentDateTime,"Post9",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Lily",currentDateTime,"Post10",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed)) //adding manually
        arrayList.add(FeedModel("Zoro",currentDateTime,"FirstPost",R.drawable.profilepicture,R.drawable.image_png_feed))
        arrayList.add(FeedModel("Hannah",currentDateTime,"Post11",R.drawable.profilepicture,R.drawable.image_png_feed))
//Implementating Like Button
     /*
        likebutton = ImageButton(this)
        likecount = TextView(this)
        var isLiked:Boolean = false
        likebutton.findViewById<View>(R.id.likeButton)
        likecount.findViewById<View>(R.id.likeCount)

        likebutton.setOnClickListener{
            if(isLiked) {
                likebutton.setImageResource(R.drawable.like)
                isLiked = false
            }
            else
            {
                isLiked = true
                likecount.text = "Liked"
                likebutton.setImageResource(R.drawable.thumbsup)
            }

        }
*/

//Implementating Like Button







        recycler_feed = findViewById<View>(R.id.feed_recycler) as RecyclerView //connect recycler view to layout
        adapter = FeedAdapter(arrayList) //Initialize adapter
        recycler_feed.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) //layout for Recycler
        recycler_feed.adapter = adapter //connecting adapter to recycler.

    }
}
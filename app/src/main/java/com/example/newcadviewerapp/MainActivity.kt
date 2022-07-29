package com.example.newcadviewerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var photoAdapter: PhotoAdapter
    private var dataList=mutableListOf<dataModel>()
    lateinit var add_picture_button_bottomnav: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_picture_button_bottomnav =findViewById(R.id.add_picture_button_bottomnav)
        add_picture_button_bottomnav.setOnClickListener()
        {
            val a = Intent(this,ShareMedia::class.java)
            startActivity(a)
        }

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= GridLayoutManager(applicationContext,3)
        photoAdapter= PhotoAdapter(applicationContext)
        recyclerView.adapter=photoAdapter

        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        dataList.add(dataModel(R.drawable.profilepicture))
        photoAdapter.setDataList(dataList)
    }
}
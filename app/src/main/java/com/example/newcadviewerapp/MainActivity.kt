package com.example.newcadviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var photoAdapter: PhotoAdapter
    private var dataList=mutableListOf<dataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= GridLayoutManager(applicationContext,3)
        photoAdapter= PhotoAdapter(applicationContext)
        recyclerView.adapter=photoAdapter

        dataList.add(dataModel(R.drawable.profilepicture))
        photoAdapter.setDataList(dataList)
    }
}
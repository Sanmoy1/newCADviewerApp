package com.example.newcadviewerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RecruiterProfile  : AppCompatActivity(){
    lateinit var add_picture_bottomnav: ImageButton
    lateinit var search_button: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recruiter_profile_page)

        search_button = findViewById(R.id.search_button_bottomnav)
        search_button.setOnClickListener()
        {
            startActivity(Intent(this,SearchProfiles::class.java))
        }


        add_picture_bottomnav=findViewById(R.id.add_picture_button_bottomnav)
        add_picture_bottomnav.setOnClickListener()
        {
            val a =Intent(this,ShareMedia::class.java)
            startActivity(a)
        }
    }
}
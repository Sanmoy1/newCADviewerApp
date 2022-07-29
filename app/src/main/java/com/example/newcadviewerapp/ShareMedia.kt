package com.example.newcadviewerapp

import android.app.Activity
import android.app.Instrumentation
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

import com.squareup.picasso.Picasso

class ShareMedia: AppCompatActivity() {

    lateinit var storagePostPicRef : StorageReference
    private lateinit var image_preview : ImageView
    lateinit var share_post_buttom:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.share_photo2)
        image_preview=findViewById(R.id.image_preview)
        share_post_buttom=findViewById(R.id.share_post_buttom)

        val contract=registerForActivityResult(ActivityResultContracts.GetContent()){     // We get the uri of the image
            image_preview.setImageURI(it)
        }

        storagePostPicRef=FirebaseStorage.getInstance().reference.child("Post Pictures")

        image_preview.setOnClickListener()
        {
            contract.launch("image/*")
        }


    }



}
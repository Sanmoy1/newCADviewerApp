package com.example.newcadviewerapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.text.TextUtils

import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask


class ShareMedia : AppCompatActivity() {

    var storagePostPicRef: StorageReference? = null
    private lateinit var image_preview: ImageView
    lateinit var close_share_post_button:ImageView
    private lateinit var share_post_buttom: ImageView
    private var imageuri: Uri? = null // nullable uri variable
    private lateinit var post_description: EditText
    private var myUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.share_photo2)
        image_preview = findViewById(R.id.image_preview)
        share_post_buttom = findViewById(R.id.share_post_button)
        post_description = findViewById(R.id.post_description)
        close_share_post_button  = findViewById(R.id.close_share_post_button)
        val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
            imageuri = it
            image_preview.setImageURI(it)
        }

        storagePostPicRef = FirebaseStorage.getInstance().reference.child("Post Pictures")

        image_preview.setOnClickListener()
        {
            contract.launch("image/*")// this will help us to load the image from gallery to the image preview
        }
        share_post_buttom.setOnClickListener()
        {
            when {
                imageuri == null -> Toast.makeText(
                    this,
                    "Please select image first.",
                    Toast.LENGTH_SHORT
                ).show()// if no image is chosen
                TextUtils.isEmpty(post_description.text.toString()) -> Toast.makeText(
                    this,
                    "Enter the description!",
                    Toast.LENGTH_SHORT
                ).show()// if the description is
                //blank it will show a toast message to fill it up before uploading the picture from the gallery
                else -> {
                    val progressBar = LoadingDialog(this)
                    progressBar.startLoading()

                    val fileref = storagePostPicRef!!.child(
                        System.currentTimeMillis().toString() + ".jpg"
                    )// the pictures will be stored uniquely
                    //  with the help of the time it was uploaded
                    var uploadTask: StorageTask<*>
                    uploadTask =
                        fileref.putFile(imageuri!!)// this will put the image in the fileref reference
                    uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                progressBar.isDismiss()
                                throw it


                            }
                        }
                        return@Continuation fileref.downloadUrl// download the url of the file to the reference fileref
                    }).addOnCompleteListener(OnCompleteListener<Uri> { task ->
                        if (task.isSuccessful)// we are storing the image uploaded to the firebase database
                        {
                            myUrl = imageuri.toString()
                            val ref =
                                FirebaseDatabase.getInstance().reference.child("Posts")// creating a seperate node for the posts
                            val postId =
                                ref.push().key// this helps us to make a random key for every post a user can post multiple pictures
                            val postMap =
                                HashMap<String, Any>()// we use a hashmap for storing each parameters as necessary
                            postMap["Postid"] = postId!!// we store the post id with a unique key
                            postMap["Description"] = post_description.text.toString()
                            postMap["Publisher"] =
                                FirebaseAuth.getInstance().currentUser!!.uid// current user
                            postMap["Postimage"] = myUrl// storing the uri of the image as a string
                            ref.child(postId).updateChildren(postMap)
                            Toast.makeText(this, "Post Uploaded Successfully!", Toast.LENGTH_SHORT)
                                .show()
                            //now the problem is where to move the intent to. is it to the recruiter profile or the student profile
                            progressBar.isDismiss()
                            close_share_post_button.setOnClickListener{
                                startActivity(Intent(this,MainActivity::class.java))
                            }

                        } else
                            progressBar.isDismiss()
                    })
                }
            }
        }


    }


}
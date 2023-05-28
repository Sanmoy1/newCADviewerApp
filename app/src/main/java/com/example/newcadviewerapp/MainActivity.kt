package com.example.newcadviewerapp



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage


class MainActivity : AppCompatActivity() {
    private lateinit var postButton:Button
    lateinit var recyclerView: RecyclerView
    lateinit var photoAdapter: PhotoAdapter
    lateinit var editProfileBtn: Button
    lateinit var AboutID: TextView
    lateinit var add_picture_button_bottomnav:ImageButton
    lateinit var search_button: ImageButton
     lateinit var feed_button :ImageButton
    private var dataList=mutableListOf<dataModel>()

    companion object{
        val IMAGE_REQUEST_CODE= 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postButton=findViewById(R.id.PostButton)
        recyclerView=findViewById(R.id.recyclerView)
        editProfileBtn=findViewById(R.id.EditProfileButtonID)
        recyclerView.layoutManager=GridLayoutManager(applicationContext,3)
        photoAdapter= PhotoAdapter(applicationContext)
        AboutID=findViewById(R.id.AboutID)
        recyclerView.adapter=photoAdapter
        postButton.setOnClickListener { pickImage() }
        editProfileBtn.setOnClickListener(){
            goToEditProfile()
        }
        add_picture_button_bottomnav = findViewById(R.id.add_picture_button_bottomnav)

        add_picture_button_bottomnav.setOnClickListener()
        {
            val a = Intent(this, ShareMedia::class.java)
            startActivity(a)
        }
       //SEARCH BUTTON
        search_button = findViewById(R.id.search_button_bottomnav)
        search_button.setOnClickListener()
        {
            startActivity(Intent(this,SearchProfiles::class.java))
        }

        //FEED BUTTON

        feed_button = findViewById(R.id.imageButton3)
        feed_button.setOnClickListener{
            startActivity(Intent(this,FeedActivity::class.java))

        }



/*
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
*/

        val storageReference = FirebaseStorage.getInstance().reference
        val imagesRef = storageReference.child("Post Pictures")//image retrieved from the firebase storage
        imagesRef.listAll().addOnCompleteListener{ listResult ->
            if (listResult.isSuccessful)
            {


                for (item in listResult.result?.items!!)
                {
                    item.downloadUrl.addOnSuccessListener { downloadUri ->
                        val dataModel=dataModel(downloadUri.toString())
                        AboutID.setText(dataModel.toString())
                        dataList.add(dataModel)
                        AboutID.setText("Hello. I am Sanmoy. Thank You for coming")
                        photoAdapter.setDataList(dataList)

                    }
                }


            }
            else
            {
                // Handle the error if the listing operation fails
                Toast.makeText(this@MainActivity, "Error retrieving images", Toast.LENGTH_SHORT).show()
            }
        }


    }
    private fun goToEditProfile(){
        val intent2 = Intent(this,EditProfile::class.java)
        startActivity(intent2)

    }
    private fun pickImage()
    {

        val intent =Intent(Intent.ACTION_PICK)
        intent.type= "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            //imageView.setImage(data?.data)

            Toast.makeText(this,"Opened gallery",Toast.LENGTH_SHORT).show()
        }








    }

//updatefirebase function to get name and about in the database
/*private fun updateFirebaseDatabase() {
    val database = FirebaseDatabase.getInstance()
    val usersRef = database.getReference("Users")

    val currentUser = FirebaseAuth.getInstance().currentUser
    val userId = currentUser?.uid
    val name = "User"
    val about = "hiring"
    if (userId != null) {
        val userRef = usersRef.child(userId)

        // Take input from the user


        userRef.child("Name").setValue(name)
        userRef.child("About").setValue(about)
    }

}
*/


}
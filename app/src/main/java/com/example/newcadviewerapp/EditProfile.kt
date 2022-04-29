package com.example.newcadviewerapp


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EditProfile: AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etUserName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etContactNo: EditText
    private lateinit var etAbout: EditText
    private lateinit var updateBtn: Button
    private lateinit var imageBtn:ImageButton

    companion object{
        const val IMAGE_REQUEST_CODE= 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_layout)
        viewInitializations()
        updateBtn.setOnClickListener {
            performEditProfile(it)
        }
        imageBtn.setOnClickListener(){
            //open gallery
            changeProfile()
        }


    }

    private fun changeProfile() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type= "image/*"
        startActivityForResult(intent, EditProfile.IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "Opened Gallery", Toast.LENGTH_SHORT).show()
            //call api here
        }
    }

    private fun viewInitializations() {

        etName = findViewById(R.id.et_first_name_edit_profile)
        etUserName = findViewById(R.id.et_last_name)
        etEmail = findViewById(R.id.et_email)
        etContactNo = findViewById(R.id.contact_info_et)
        etAbout = findViewById(R.id.et_des)
        updateBtn=findViewById(R.id.bt_register)
        imageBtn=findViewById(R.id.image_editprofile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun validateInput(): Boolean {
        if (etName.text.toString() == "") {
            etName.error = "Please Enter your  Name"
            return false
        }
        if (etUserName.text.toString() == "") {
            etUserName.error = "Please Enter UserName"
            return false
        }
        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Email"
            return false
        }

        if (etContactNo.text.toString() == "") {
            etContactNo.error = "Please Enter Contact No"
            return false
        }
        if (etAbout.text.toString() == "") {
            etAbout.error = "Please Enter Status or About"
            return false
        }
        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter Valid Email"
            return false
        }

        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun performEditProfile(view:View) {
        if (validateInput()) {

            // Input is valid, here send data to database

            val name = etName.text.toString()
            val userName = etUserName.text.toString()
            val email = etEmail.text.toString()
            val contactNo = etContactNo.text.toString()
            val about = etAbout.text.toString()

            Toast.makeText(this, "Profile Update Successfully", Toast.LENGTH_SHORT).show()
            //make api call here to server
        }

    }
}
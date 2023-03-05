package com.example.newcadviewerapp

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoadingDialog(val mActivity: Activity) {
    private lateinit var isdialog:AlertDialog
    fun startLoading() {
    //setting the view
        val inflater=mActivity.layoutInflater
        val dialogView=inflater.inflate(R.layout.loading_item,null)// this will inflate the progress bar
        //setting the dialog
        val builder=AlertDialog.Builder(mActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog=builder.create()
        isdialog.show()
    }
    fun isDismiss()
    {
        isdialog.dismiss()
    }


    }

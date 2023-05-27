package com.example.newcadviewerapp



data class FeedModel(
    val createdBy: String,
    val createdAt: String = "",
    val postTitle: String = "",
    val profileIcon:Int,
    val postImage:Int
   )
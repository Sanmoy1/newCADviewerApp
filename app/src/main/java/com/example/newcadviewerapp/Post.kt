package com.example.newcadviewerapp

import com.google.firebase.firestore.auth.User

data class Post (
    val text: String = "",
    val createdBy: User,
    val createdAt: Long = 0L,
    val likedBy: ArrayList<String> = ArrayList())
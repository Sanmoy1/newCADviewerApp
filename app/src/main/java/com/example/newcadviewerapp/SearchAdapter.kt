package com.example.newcadviewerapp

import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class SearchAdapter(options: FirestoreRecyclerOptions<SearchModel>, val listener: IPostAdapter) : FirestoreRecyclerAdapter<SearchModel, SearchAdapter.SearchViewHolder>(
    options
) {
        class SearchViewHolder
}
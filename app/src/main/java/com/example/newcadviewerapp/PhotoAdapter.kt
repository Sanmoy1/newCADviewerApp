package com.example.newcadviewerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(var context: Context): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var datalist= emptyList<dataModel>()


    internal fun setDataList(datalist:List<dataModel>) {

        this.datalist=datalist
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var image:ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.photo_layout,parent,false)//this inflates all the images into the recyclerView
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        var data=datalist[position]
        //holder.image.setImageResource(data.image)
        Glide.with(context).load(data.image).into(holder.image)
    }

    override fun getItemCount() =datalist.size
}

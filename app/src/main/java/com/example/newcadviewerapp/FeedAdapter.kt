package com.example.newcadviewerapp


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView



class FeedAdapter(private val arraylist: ArrayList<FeedModel>) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>()
 {
     //private var arraylist=mutableListOf<FeedModel>()


    @SuppressLint("SetTextI18n")
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //like button and counter
       private var likebutton:ImageButton = itemView.findViewById(R.id.likeButton)
       private var likecount:TextView = itemView.findViewById(R.id.likeCount)
//comment button and EditText Comment
        private var commentbutton:ImageButton = itemView.findViewById(R.id.commentButton)
        private var commentbox:EditText = itemView.findViewById(R.id.commentBox)
        private var commentshow:TextView =itemView.findViewById(R.id.showComment)
        private var commentshowbutton:ImageButton =itemView.findViewById(R.id.commentSubmitButton)

        //share button
        private var shareButton:ImageButton = itemView.findViewById(R.id.shareButton)


        val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val createdAt: TextView = itemView.findViewById(R.id.createdAt)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
        val postImage :ImageView  = itemView.findViewById(R.id.post_id)



        init {
            //Implementating Like Button
            var isLiked = false
          //  likebutton.findViewById<View>(R.id.likeButton)
           // likecount.findViewById<View>(R.id.likeCount)

            likebutton.setOnClickListener {
                if (isLiked) {
                    likebutton.setBackgroundResource(R.drawable.like)
                    isLiked = false
                    likecount.text = ""
                } else {
                    isLiked = true
                    likecount.text = "You liked this Post!"
                    //likebutton.setImageResource(R.drawable.thumb_up_filled_gesture)
                    likebutton.setBackgroundResource(R.drawable.thumb_up_filled_gesture)

                }

            }
            //Implementating Like Button

 //Implementing Comment Button
var isCommentClicked = false
commentbutton.setOnClickListener{
    if(!isCommentClicked) {
        commentbox.visibility = View.VISIBLE
        commentshow.visibility = View.INVISIBLE
        isCommentClicked = true
    }
    else
    {
        commentbox.visibility = View.INVISIBLE
        commentshow.visibility = View.VISIBLE
        isCommentClicked = false
    }

}
//getting comment into TextView
commentshowbutton.setOnClickListener{
    val commentText = commentbox.text.toString()

    if(commentText.isNotEmpty()) {
        commentbox.visibility = View.INVISIBLE
        commentshow.text = commentText
        commentshow.visibility = View.VISIBLE

    }
    else{
        commentshow.visibility = View.VISIBLE
        commentshow.text = " "

    }

}




//Implementing Comment Button ends

//implementing Share
 shareButton.setOnClickListener{
     val shareIntent = Intent(Intent.ACTION_SEND)
     shareIntent.type = "text/plain"
     shareIntent.putExtra(Intent.EXTRA_TEXT, "Shared Worked !")
     startActivity(itemView.context,Intent.createChooser(shareIntent, "Share this post!"),null)
 }



//implementing Share ends
        }














    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_post,parent,false)
        return PostViewHolder(view)

    }




    override fun getItemCount(): Int {
        return arraylist.size
    }

     @SuppressLint("RestrictedApi")
     override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentFeed = arraylist[position]
         holder.userName.text = currentFeed.createdBy
         holder.createdAt.text = currentFeed.createdAt
         holder.postTitle.text = currentFeed.postTitle
         holder.userImage.setImageResource(currentFeed.profileIcon)
         holder.postImage.setImageResource(currentFeed.postImage)






     }
 }







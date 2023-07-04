package com.example.farmease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val learnList : ArrayList<Learn>)
    :RecyclerView.Adapter<MyAdapter.LearnViewHolder>(){
    var onItemClick : ((Learn) -> Unit)? = null
    class LearnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.mImageView)
        val textView : TextView = itemView.findViewById(R.id.mTvLearn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return LearnViewHolder(view)
    }

    override fun getItemCount(): Int {
        return learnList.size
    }

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        val learn = learnList[position]
        holder.imageView.setImageResource(learn.image)
        holder.textView.text = learn.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(learn)
        }
    }
}


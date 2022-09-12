package com.example.tujweed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tujweed.R
import com.example.tujweed.utility.Videos

class VideosAdapter(val videos: List<Videos>): RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    inner class VideosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_video,parent,false))
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {

        val currentVideo = videos[position]
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text = currentVideo.title
    }

    override fun getItemCount() = videos.size


}
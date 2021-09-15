package com.example.classictube.video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classictube.R

class VideoAdapter(private val list: List<String>):RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val item= R.layout.item_video
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
       // val binding = ItemGameBinding.bind(viewItem)
    }
}
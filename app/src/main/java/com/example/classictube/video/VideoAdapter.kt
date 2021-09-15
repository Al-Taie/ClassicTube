package com.example.classictube.video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classictube.R
import com.example.classictube.databinding.ItemVideoBinding
import com.example.classictube.interfaces.VideoInteractionListener

class VideoAdapter(private val list: List<String>?, private val listener: VideoInteractionListener?):RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val item= R.layout.item_video
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.binding.apply {
            titleText.text = "The Walking Dead"
            directorText.text = "Joan Miller"
            durationText.text = "1:24:55"
//            imageView.background = ""
            itemCard.setOnClickListener { getVideoActivity(position) }
        }
    }

    private fun getVideoActivity(position: Int) {

    }

    override fun getItemCount() = 5

    class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
       val binding = ItemVideoBinding.bind(viewItem)
    }
}
package com.example.classictube.video

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classictube.R
import com.example.classictube.data.domain.Item
import com.example.classictube.databinding.ItemVideoBinding
import com.example.classictube.interfaces.VideoInteractionListener

class VideoAdapter(private val list: List<Item>, private val listener: VideoInteractionListener) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val item = R.layout.item_video
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return VideoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.apply {
            titleText.text = currentItem.title
            directorText.text = currentItem.director
            Glide.with(imageView).load(currentItem.art)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(imageView)
            durationText.text = "${currentItem.duration / 60}:00"
            root.setOnClickListener { listener.videoPressed(currentItem.url) }

        }
    }

    override fun getItemCount() = list.size

    class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemVideoBinding.bind(viewItem)
    }
}
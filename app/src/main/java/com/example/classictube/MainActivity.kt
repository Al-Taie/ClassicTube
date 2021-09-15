package com.example.classictube

import android.content.Intent
import android.view.LayoutInflater
import com.example.classictube.base.BaseActivity
import com.example.classictube.data.NetWork
import com.example.classictube.databinding.ActivityMainBinding
import com.example.classictube.interfaces.VideoInteractionListener
import com.example.classictube.video.VideoAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(), VideoInteractionListener {

    override val theme: Int
        get() = R.style.Theme_ClassicTube

    override fun setup() {
        NetWork.makeRequestUsingOkhttp()
        val adapter = VideoAdapter(null,null)
        binding.recycleView.adapter = adapter
    }

    override fun callBack() {

    }

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun videoPressed() {
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent)
    }
}
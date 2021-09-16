package com.example.classictube

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import com.example.classictube.base.BaseActivity
import com.example.classictube.data.NetWork
import com.example.classictube.data.domain.Item
import com.example.classictube.data.domain.VideoData
import com.example.classictube.databinding.ActivityMainBinding
import com.example.classictube.interfaces.VideoInteractionListener
import com.example.classictube.util.Constants
import com.example.classictube.video.VideoAdapter
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : BaseActivity<ActivityMainBinding>(), VideoInteractionListener {

    private val client = OkHttpClient()
    private val gson = Gson()
    private var videoList = mutableListOf<Item>()

    override val theme: Int
        get() = R.style.Theme_ClassicTube

    override fun setup() {
        makeRequestUsingOkhttp()

    }

    override fun callBack() {

    }


    fun makeRequestUsingOkhttp(){
        val request =
            Request.Builder().
            url("https://raw.githubusercontent.com/Bareq-altaamah/mock/main/classic.json").build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }
            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { jsonString ->
                    val result = gson.fromJson(jsonString, VideoData::class.java)
                    val test = result.feed.joinToString { it.id }
                    Log.i("NETWORK",test)
                    result.feed.forEach {
                        it.items.forEach { video ->
                            videoList.add(video)
                        }
                    }
                    runOnUiThread {
                        val adapter = VideoAdapter(videoList,this@MainActivity)
                        binding.recycleView.adapter = adapter
                    }


                }
            }
        })
    }

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun videoPressed(url: String) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra(Constants.URL_EXTRA,url)
        startActivity(intent)
    }
}
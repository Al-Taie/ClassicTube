package com.example.classictube.data

import android.util.Log
import com.example.classictube.data.domain.Item
import com.example.classictube.data.domain.VideoData
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object NetWork {
    private val client = OkHttpClient()
    private val gson = Gson()
    var itemsList = listOf<Item>()
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
                    itemsList = result.feed[0].items

                }
            }
        })
    }

}
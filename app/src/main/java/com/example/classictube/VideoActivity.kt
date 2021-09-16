package com.example.classictube

import android.net.Uri
import android.view.LayoutInflater
import com.example.classictube.base.BaseActivity
import com.example.classictube.databinding.ActivityVideoBinding
import com.example.classictube.util.Constants
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class VideoActivity : BaseActivity<ActivityVideoBinding>() {

    lateinit var exoPlayer : SimpleExoPlayer

    override val theme: Int
        get() = R.style.Theme_ClassicTube

    override fun setup() {
        val url = intent.getStringExtra(Constants.URL_EXTRA)
        initVideo(url)

    }

    private fun initVideo(videoURL : String?){
        val bandwidthMeter = DefaultBandwidthMeter()
        val trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
        exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        val videoUri = Uri.parse(videoURL)
        val dataSourceFactory = DefaultHttpDataSourceFactory("exoplayer_video")
        val extractorsFactory = DefaultExtractorsFactory()
        val mediaSource = ExtractorMediaSource(videoUri,dataSourceFactory,extractorsFactory,null,null)
        binding.idExoPlayerVIew.player = exoPlayer
        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true
    }

    override fun callBack() {}

    override val inflate: (LayoutInflater) -> ActivityVideoBinding
        get() = ActivityVideoBinding::inflate

}
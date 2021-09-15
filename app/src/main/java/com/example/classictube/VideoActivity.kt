package com.example.classictube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.classictube.base.BaseActivity
import com.example.classictube.databinding.ActivityVideoBinding

class VideoActivity : BaseActivity<ActivityVideoBinding>() {
    override val theme: Int
        get() = R.style.Theme_ClassicTube

    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater) -> ActivityVideoBinding
        get() = ActivityVideoBinding::inflate

}
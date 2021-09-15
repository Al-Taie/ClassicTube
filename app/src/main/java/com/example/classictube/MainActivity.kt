package com.example.classictube

import android.view.LayoutInflater
import com.example.classictube.base.BaseActivity
import com.example.classictube.data.NetWork
import com.example.classictube.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val theme: Int
        get() = R.style.Theme_ClassicTube

    override fun setup() {
        NetWork.makeRequestUsingOkhttp()
    }

    override fun callBack() {

    }

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}
package com.begers.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.begers.retrofitkotlin.R

class MainActivity : AppCompatActivity() {
    //https://api.nomics.com/v1/prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb
    //prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
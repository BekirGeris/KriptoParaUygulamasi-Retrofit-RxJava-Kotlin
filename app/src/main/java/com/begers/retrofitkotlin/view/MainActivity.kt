package com.begers.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.begers.retrofitkotlin.R
import com.begers.retrofitkotlin.model.CryptoModel

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "/https://api.nomics.com/v1/"
    private lateinit var cryptoModels: ArrayList<CryptoModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
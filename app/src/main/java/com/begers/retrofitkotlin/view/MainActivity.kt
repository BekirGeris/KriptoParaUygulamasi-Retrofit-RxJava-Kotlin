package com.begers.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.begers.retrofitkotlin.R
import com.begers.retrofitkotlin.model.CryptoModel
import com.begers.retrofitkotlin.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "/https://api.nomics.com/v1/"
    private lateinit var cryptoModels: ArrayList<CryptoModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getAll()

        call.enqueue(object: Callback<List<CryptoModel>> {
            override fun onResponse(call: Call<List<CryptoModel>>, response: Response<List<CryptoModel>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                        for (cryptoModel in cryptoModels){
                            println(cryptoModel.currency)
                            println(cryptoModel.price)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {

            }
        })
    }
}
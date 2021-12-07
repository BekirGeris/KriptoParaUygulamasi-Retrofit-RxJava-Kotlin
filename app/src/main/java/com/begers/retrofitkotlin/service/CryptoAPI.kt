package com.begers.retrofitkotlin.service

import com.begers.retrofitkotlin.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
    //https://api.nomics.com/v1/
    //prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb

    //retrofit call
    @GET("prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb")
    fun getAllCall() : Call<List<CryptoModel>>

    @GET("prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb")
    fun getAllObservable() : Observable<List<CryptoModel>>
}
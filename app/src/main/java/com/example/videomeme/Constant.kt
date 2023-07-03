package com.example.videomeme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {

    private const val BASE_URL = "https://foodapi.cyclic.app/"

    private val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}


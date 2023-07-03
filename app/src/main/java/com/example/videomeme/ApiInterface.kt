package com.example.videomeme

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("get/voices")
    suspend fun getData(): Response<ResponseMediaData>
}


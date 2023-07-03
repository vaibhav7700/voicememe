package com.example.videomeme

data class ResponseMediaData(
    val data: List<dataList>,
    val message: String,
    val status: Boolean
)

data class dataList(
    val __v: Int,
    val _id: String,
    val name: String,
    val new_Date: String,
    val voiceUrl: String
)
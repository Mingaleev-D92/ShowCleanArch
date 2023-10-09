package com.example.showcleanarch.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TvShowDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_thumbnail_path")
    val imageThumbnailPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("network")
    val network: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("status")
    val status: String
)
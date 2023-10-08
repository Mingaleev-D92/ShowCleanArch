package com.example.showcleanarch.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ShowListDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("total")
    val total: String,
    @SerializedName("tv_shows")
    val tvShowsResult: List<TvShowDto>
)
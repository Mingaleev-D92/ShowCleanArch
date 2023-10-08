package com.example.showcleanarch.domain.model

data class TvShowModel(
    val country: String,
    val id: Int,
    val imageThumbnailPath: String,
    val name: String,
    val network: String,
    val permalink: String,
    val startDate: String,
    val status: String
)

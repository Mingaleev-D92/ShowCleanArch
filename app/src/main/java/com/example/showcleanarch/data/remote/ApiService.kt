package com.example.showcleanarch.data.remote

import com.example.showcleanarch.data.remote.dto.ShowListDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


interface ApiService {

   companion object {
      const val BASE_URL = "https://www.episodate.com/api/"
   }

   @GET("most-popular")
   suspend fun fetchAllShow(
       @Query("page") page: Int
   ): ShowListDto
}
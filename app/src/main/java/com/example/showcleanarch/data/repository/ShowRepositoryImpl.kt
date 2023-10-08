package com.example.showcleanarch.data.repository

import com.example.showcleanarch.data.mapper.mapToDomain
import com.example.showcleanarch.data.remote.ApiService
import com.example.showcleanarch.domain.model.TvShowModel
import com.example.showcleanarch.domain.repository.ShowRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


class ShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) :ShowRepository{
 //  suspend fun fetchAllShow() = apiService.fetchAllShow(page = 1).tvShowsResult.map { it.mapToDomain() }
   override suspend fun fetchShowList(): List<TvShowModel> {
      return apiService.fetchAllShow(page = 1).tvShowsResult.map { it.mapToDomain() }
   }
}
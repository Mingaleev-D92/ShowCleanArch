package com.example.showcleanarch.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.showcleanarch.data.mapper.mapToDomain
import com.example.showcleanarch.data.remote.ApiService
import com.example.showcleanarch.data.remote.dto.TvShowDto
import com.example.showcleanarch.domain.model.TvShowModel
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class LatesShowPagingSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, TvShowModel>() {
   override fun getRefreshKey(state: PagingState<Int, TvShowModel>): Int? {
      return 1
   }

   override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowModel> {
      val key = params.key ?: 1

      return try {
         val response = apiService.fetchAllShow(key).tvShowsResult.map(TvShowDto::mapToDomain)

         LoadResult.Page(
             data = response,
             prevKey = null,
             nextKey = key + 1
         )
      } catch (ex: Exception) {
         LoadResult.Error(ex)
      }
   }
}
package com.example.showcleanarch.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.showcleanarch.data.remote.ApiService
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


class ShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
)  {

   fun fetchShowList() = Pager(config = PagingConfig(pageSize = 50)) {
      LatesShowPagingSource(apiService)
   }.flow


}
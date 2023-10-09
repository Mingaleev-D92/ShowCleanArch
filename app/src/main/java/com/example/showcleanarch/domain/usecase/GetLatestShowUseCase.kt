package com.example.showcleanarch.domain.usecase

import androidx.paging.PagingData
import com.example.showcleanarch.data.repository.ShowRepositoryImpl
import com.example.showcleanarch.domain.model.TvShowModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class GetLatestShowUseCase @Inject constructor(
    private val repository: ShowRepositoryImpl
) {

   operator fun invoke(): Flow<PagingData<TvShowModel>> = repository.fetchShowList()
}
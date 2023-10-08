package com.example.showcleanarch.domain.repository

import com.example.showcleanarch.domain.model.TvShowModel

/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


interface ShowRepository {

   suspend fun fetchShowList():List<TvShowModel>
}
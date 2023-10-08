package com.example.showcleanarch.data.mapper

import com.example.showcleanarch.data.remote.dto.TvShowDto
import com.example.showcleanarch.domain.model.TvShowModel


/**
 * @author : Mingaleev D
 * @data : 08.10.2023
 */


fun TvShowDto.mapToDomain(): TvShowModel {
   return TvShowModel(
       country = country,
       id = id,
       imageThumbnailPath = imageThumbnailPath,
       name = name,
       network = network,
       permalink = permalink,
       startDate = startDate,
       status = status
   )
}
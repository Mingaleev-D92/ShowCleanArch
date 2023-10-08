package com.example.showcleanarch.ui.components

import com.example.showcleanarch.domain.model.TvShowModel


/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */

sealed class UIState<out T : Any> {
   object Error : UIState<Nothing>()
   object Loading : UIState<Nothing>()
   class Result<out T : Any>(val result: T) : UIState<T>()
}
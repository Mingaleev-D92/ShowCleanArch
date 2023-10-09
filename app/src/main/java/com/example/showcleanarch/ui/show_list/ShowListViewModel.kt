package com.example.showcleanarch.ui.show_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.showcleanarch.data.repository.ShowRepositoryImpl
import com.example.showcleanarch.domain.model.TvShowModel
import com.example.showcleanarch.domain.usecase.GetLatestShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowListViewModel @Inject constructor(
    private val repositoryImpl: ShowRepositoryImpl,
    private val getLatestShowUseCase: GetLatestShowUseCase
) : ViewModel() {

   private val _showState = MutableStateFlow<PagingData<TvShowModel>>(PagingData.empty())
   val showState: StateFlow<PagingData<TvShowModel>> = _showState.asStateFlow()


   init {
      viewModelScope.launch {
        // repositoryImpl.fetchShowList()
          getLatestShowUseCase()
             .cachedIn(viewModelScope)
             .collectLatest(_showState::emit)
      }
   }


}
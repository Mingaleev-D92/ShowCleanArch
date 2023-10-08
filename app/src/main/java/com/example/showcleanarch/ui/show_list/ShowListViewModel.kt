package com.example.showcleanarch.ui.show_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showcleanarch.domain.model.TvShowModel
import com.example.showcleanarch.domain.repository.ShowRepository
import com.example.showcleanarch.ui.components.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowListViewModel @Inject constructor(
    private val repository: ShowRepository
) : ViewModel() {

   private val _showState = MutableStateFlow<UIState<List<TvShowModel>>>(UIState.Loading)
   val showState: StateFlow<UIState<List<TvShowModel>>> = _showState.asStateFlow()

   init {
      viewModelScope.launch {
         _showState.emit(UIState.Loading)
         try {
            val fetchShowList = repository.fetchShowList()
            _showState.emit(UIState.Result(result = fetchShowList))
         } catch (ex: Exception) {
            _showState.emit(UIState.Error)
         }
      }
   }

}
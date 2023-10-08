package com.example.showcleanarch.ui.show_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showcleanarch.domain.repository.ShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowListViewModel @Inject constructor(
    private val repository: ShowRepository
) : ViewModel() {

   init {
      viewModelScope.launch {
         repository.fetchShowList()
      }

   }

}
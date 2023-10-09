package com.example.showcleanarch.ui.show_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.example.showcleanarch.R
import com.example.showcleanarch.databinding.FragmentShowListBinding
import com.example.showcleanarch.ui.components.autoNull
import com.example.showcleanarch.ui.components.extensions.collectRepeatOnStart
import com.example.showcleanarch.ui.components.viewBinding
import com.example.showcleanarch.ui.show_list.adapter.ShowListAdapter
import com.example.showcleanarch.ui.show_list.adapter.ShowListStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ShowListFragment : Fragment(R.layout.fragment_show_list) {

   private val binding by viewBinding(FragmentShowListBinding::bind)
   private val viewModel by viewModels<ShowListViewModel>()
   private val sAdapter by autoNull { ShowListAdapter() }
   private val listRefreshSateAdapter by autoNull { ShowListStateAdapter(retryListener = { sAdapter.retry() }) }
   private val listStateAdapter by autoNull { ShowListStateAdapter(retryListener = { sAdapter.retry() }) }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      initAdapter()
      subscribeUI()

   }

   private fun subscribeUI() {
      viewModel.showState.collectRepeatOnStart(viewLifecycleOwner) { paginData ->
         viewLifecycleOwner.lifecycleScope.launch {
            sAdapter.submitData(paginData)
         }
      }
      sAdapter.loadStateFlow.collectRepeatOnStart(viewLifecycleOwner) { combinedLoadSate ->
         listRefreshSateAdapter.loadState = combinedLoadSate.refresh
         listStateAdapter.loadState = combinedLoadSate.append
      }
   }

   private fun initAdapter() {
      binding.showListRv.adapter = ConcatAdapter(
          listRefreshSateAdapter,
          sAdapter,
          listStateAdapter
      )
   }

}
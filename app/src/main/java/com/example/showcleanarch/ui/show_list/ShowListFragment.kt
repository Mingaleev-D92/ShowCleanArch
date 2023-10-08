package com.example.showcleanarch.ui.show_list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.showcleanarch.R
import com.example.showcleanarch.databinding.FragmentShowListBinding
import com.example.showcleanarch.ui.components.UIState
import com.example.showcleanarch.ui.components.autoNull
import com.example.showcleanarch.ui.components.extensions.collectRepeatOnStart
import com.example.showcleanarch.ui.components.viewBinding
import com.example.showcleanarch.ui.show_list.adapter.ShowListAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowListFragment : Fragment(R.layout.fragment_show_list) {

   private val binding by viewBinding(FragmentShowListBinding::bind)
   private val viewModel by viewModels<ShowListViewModel>()
   private val sAdapter by autoNull { ShowListAdapter() }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      initAdapter()
      subscribeUI()

   }

   private fun subscribeUI() {
      viewModel.showState.collectRepeatOnStart(viewLifecycleOwner) { state ->
         when (state) {
            UIState.Error -> {
               Snackbar.make(
                   requireActivity().findViewById(android.R.id.content),
                   getString(R.string.connection_error_try_again_later), Snackbar.LENGTH_LONG
               ).show()
            }

            UIState.Loading -> {
               binding.progressBar.isVisible = true
            }

            is UIState.Result -> {
               binding.progressBar.isVisible = false
               sAdapter.submitList(state.result)
            }
         }
      }
   }

   private fun initAdapter() {
      binding.showListRv.adapter = sAdapter
   }

}
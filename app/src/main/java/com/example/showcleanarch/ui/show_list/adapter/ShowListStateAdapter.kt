package com.example.showcleanarch.ui.show_list.adapter

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.showcleanarch.databinding.ShowStateListItemBinding
import com.example.showcleanarch.ui.components.viewBinding

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class ShowListStateAdapter(
    private val retryListener: () -> Unit
) : LoadStateAdapter<ShowListStateAdapter.ShowListStateViewHolder>() {

   override fun onCreateViewHolder(
       parent: ViewGroup,
       loadState: LoadState
   ): ShowListStateViewHolder = ShowListStateViewHolder(
       parent.viewBinding { layoutInflater, viewGroup, _ ->
          ShowStateListItemBinding.inflate(layoutInflater, viewGroup, false)
       }
   )

   override fun onBindViewHolder(holder: ShowListStateViewHolder, loadState: LoadState) {
      holder.bind(loadState)
   }

   inner class ShowListStateViewHolder(
       private val binding: ShowStateListItemBinding
   ) :
       RecyclerView.ViewHolder(binding.root) {

      init {
         binding.retryButton.setOnClickListener { retryListener() }
      }

      fun bind(loadState: LoadState) {
         binding.loadingIndicator.isVisible = loadState is LoadState.Loading
         binding.error.isVisible = loadState is LoadState.Error
      }
   }
}
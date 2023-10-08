package com.example.showcleanarch.ui.show_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.showcleanarch.R
import com.example.showcleanarch.databinding.FragmentShowListBinding
import com.example.showcleanarch.ui.components.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowListFragment : Fragment(R.layout.fragment_show_list) {

   private val binding by viewBinding(FragmentShowListBinding::bind)
   private val viewModel by viewModels<ShowListViewModel>()

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
   }


}
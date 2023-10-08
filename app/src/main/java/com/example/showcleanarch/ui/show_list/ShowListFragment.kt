package com.example.showcleanarch.ui.show_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.showcleanarch.R
import com.example.showcleanarch.databinding.FragmentShowListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowListFragment : Fragment(R.layout.fragment_show_list) {

   private var _binding: FragmentShowListBinding? = null
   private val binding by lazy { _binding!! }
   private val viewModel by viewModels<ShowListViewModel>()

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentShowListBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }

}
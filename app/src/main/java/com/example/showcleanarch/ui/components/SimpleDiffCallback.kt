package com.example.showcleanarch.ui.components

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil


/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class SimpleDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
   override fun areItemsTheSame(oldItem: T, newItem: T) =
       oldItem::class == newItem::class

   @SuppressLint("DiffUtilEquals")
   override fun areContentsTheSame(oldItem: T, newItem: T) =
       oldItem == newItem

}
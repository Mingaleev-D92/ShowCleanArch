package com.example.showcleanarch.ui.show_list.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.showcleanarch.R
import com.example.showcleanarch.databinding.ShowListItemBinding
import com.example.showcleanarch.domain.model.TvShowModel
import com.example.showcleanarch.ui.components.SimpleDiffCallback
import com.example.showcleanarch.ui.components.viewBinding

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class ShowListAdapter() : PagingDataAdapter<TvShowModel, ShowListAdapter.MyListViewHolder>(SimpleDiffCallback()) {

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder =
       MyListViewHolder(
           binding = parent.viewBinding { layoutInflater, viewGroup, _ ->
              ShowListItemBinding.inflate(layoutInflater, viewGroup, false)
           }
       )

   override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
      val item = getItem(position) ?: return

      holder.bind(item)
   }

   inner class MyListViewHolder(val binding: ShowListItemBinding) :
       RecyclerView.ViewHolder(binding.root) {
      fun bind(item: TvShowModel) {
         //text
         binding.title.text = item.name
         binding.descriptionTv.text = item.permalink
         binding.releaseDate.text = item.startDate
         //img
         binding.poster.loadImage(item.imageThumbnailPath)
      }
   }
}
fun ImageView.loadImage(path: String?) {
   Glide.with(this.context).load(path)
       .apply(centerCropTransform().error(R.drawable.baseline_error_24)).into(this)
}

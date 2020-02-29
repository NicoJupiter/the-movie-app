package com.gmail.eamosse.imdb.ui.trending.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.TrendingTv
import com.gmail.eamosse.imdb.databinding.TrendingTvItemBinding

class TrendingTvAdapter(private val items: List<TrendingTv> ) : RecyclerView.Adapter<TrendingTvAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TrendingTvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrendingTv) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: TrendingTvItemBinding = TrendingTvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}
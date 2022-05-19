package com.example.coursework.adatpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.coursework.R
import com.example.coursework.adatpters.viewholders.EpisodeViewHolder
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.model.episode.ResultEpisode


class EpisodeAdapter(val listener: EpisodeClickListener) : ListAdapter<ResultEpisode,EpisodeViewHolder>(EpisodeDiffCallback()){

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder( LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episodes, parent, false),listener)

    }
}



class EpisodeDiffCallback  : DiffUtil.ItemCallback<ResultEpisode>() {
    override fun areItemsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
        return oldItem== newItem
    }

    override fun areContentsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
        return oldItem.id == newItem.id
    }
}

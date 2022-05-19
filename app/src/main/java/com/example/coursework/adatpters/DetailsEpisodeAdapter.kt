package com.example.coursework.adatpters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.coursework.R
import com.example.coursework.adatpters.viewholders.DetailsEpisodeViewHolder
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.model.episode.ResultEpisode

class DetailsEpisodeAdapter(val listener:EpisodeClickListener) : ListAdapter<ResultEpisode, DetailsEpisodeViewHolder>(DeatailsEpisodeCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsEpisodeViewHolder {
       return DetailsEpisodeViewHolder( LayoutInflater.from(parent.context)
           .inflate(R.layout.item_details_episode, parent, false),listener)
    }

    override fun onBindViewHolder(holder: DetailsEpisodeViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }

}


class DeatailsEpisodeCallback : DiffUtil.ItemCallback<ResultEpisode>() {
    override fun areItemsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
        return oldItem.id==newItem.id
    }
}

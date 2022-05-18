package com.example.coursework.adatpters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.model.episode.ResultEpisode
import kotlinx.android.synthetic.main.item_details_episode.view.*

class DetailsEpisodeViewHolder (itemView: View, val listener: EpisodeClickListener): RecyclerView.ViewHolder(itemView)  {

    fun onBind(item: ResultEpisode) {
        itemView.name.text= item.name
        itemView.air_date.text= item.air_date
        itemView.episode.text= item.episode

        itemView.setOnClickListener {
            listener.onEpisodeClick(item)
        }
    }

}
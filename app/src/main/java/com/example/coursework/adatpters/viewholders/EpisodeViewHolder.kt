package com.example.coursework.adatpters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.model.episode.ResultEpisode
import kotlinx.android.synthetic.main.item_character.view.name
import kotlinx.android.synthetic.main.item_episodes.view.*

class EpisodeViewHolder(itemView: View, val listener:EpisodeClickListener) : RecyclerView.ViewHolder(itemView) {
    fun onBind(result: ResultEpisode) {
        itemView.name.text = result.name
        itemView.air_date.text = result.air_date
        itemView.episode.text = result.episode

        itemView.setOnClickListener {
            listener.onEpisodeClick(item = result)
        }
    }
}
package com.example.coursework.adatpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.coursework.R
import com.example.coursework.adatpters.viewholders.LocationViewHolder
import com.example.coursework.listeners.LocationItemClickListener
import com.example.coursework.model.location.ResultLocation

class LocationAdapter(val listener:LocationItemClickListener) : ListAdapter<ResultLocation,LocationViewHolder>(LocationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_locations, parent, false),listener)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }

}



class LocationDiffCallback: DiffUtil.ItemCallback<ResultLocation>() {
    override fun areItemsTheSame(oldItem: ResultLocation, newItem: ResultLocation): Boolean {
        return oldItem== newItem
    }

    override fun areContentsTheSame(oldItem: ResultLocation, newItem: ResultLocation): Boolean {
        return oldItem.id == newItem.id
    }
}

package com.example.coursework.adatpters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.listeners.LocationItemClickListener
import com.example.coursework.model.location.ResultLocation
import kotlinx.android.synthetic.main.item_locations.view.*

class LocationViewHolder (itemView: View,val  listener: LocationItemClickListener) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: ResultLocation) {
        itemView.name.text =item.name
        itemView.type.text =item.type
        itemView.demension.text =item.dimension

        itemView.setOnClickListener {
            listener.onLocationItemClick(item = item)
        }

    }


}
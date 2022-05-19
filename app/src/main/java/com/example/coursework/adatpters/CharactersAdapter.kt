package com.example.coursework.adatpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.coursework.R
import com.example.coursework.adatpters.viewholders.CharacterViewHolder
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.model.character.ResultCharacter

class CharactersAdapter(val listener:CharacterClickListener) : ListAdapter<ResultCharacter, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false),listener
        )


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}

private class CharacterDiffCallback : DiffUtil.ItemCallback<ResultCharacter>() {
    override fun areItemsTheSame(oldItem: ResultCharacter, newItem: ResultCharacter): Boolean {
        return oldItem== newItem
    }

    override fun areContentsTheSame(oldItem: ResultCharacter, newItem: ResultCharacter ): Boolean {
        return oldItem.id == newItem.id
    }
}
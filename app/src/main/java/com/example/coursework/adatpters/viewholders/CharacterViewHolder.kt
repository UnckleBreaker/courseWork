package com.example.coursework.adatpters.viewholders

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.model.character.ResultCharacter
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterViewHolder(itemView: View,
        val listener:CharacterClickListener): RecyclerView.ViewHolder(itemView) {
    fun onBind(result: ResultCharacter) {
        itemView.name.text = result.name
        itemView.species.text = result.species
        itemView.gender.text = result.gender
        itemView.status.text =result.status
        itemView.imageView.setImageBitmap(BitmapFactory.decodeFile(result.image.path))

     itemView.setOnClickListener {
         listener.onClick("Character",result)
     }

    }

}
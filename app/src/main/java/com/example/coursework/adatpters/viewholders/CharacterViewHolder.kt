package com.example.coursework.adatpters.viewholders

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.model.character.Result
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(result: Result) {
        itemView.name.text = result.name
        itemView.species.text = result.species
        itemView.gender.text = result.gender
        itemView.imageView.setImageBitmap(BitmapFactory.decodeFile(result.image.path))

    }


}
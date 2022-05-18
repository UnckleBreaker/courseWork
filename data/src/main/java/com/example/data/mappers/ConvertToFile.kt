package com.example.data.mappers

import android.content.Context
import com.bumptech.glide.Glide
import java.io.File

class ConvertToFile {
    companion object{
        fun toFile(context:Context,url: String): File {
            return Glide
                .with(context)
                .asFile()
                .load(url)
                .submit()
                .get()
        }
    }
}
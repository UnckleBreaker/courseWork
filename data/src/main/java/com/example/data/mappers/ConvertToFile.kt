package com.example.data.mappers

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import java.io.File

@GlideModule
class ConvertToFile :AppGlideModule() {
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
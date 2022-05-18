package com.example.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.data.db.entity.episode.EntityEpisode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ResultDefaultTypeConverter {
    @TypeConverter
    fun fromString(value: String?): List<String> {
        val listType = object :
            TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
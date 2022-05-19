package com.example.data.db.typeconverter
import com.example.data.db.entity.character.Location
import com.example.data.db.entity.character.Origin
import java.io.File
import androidx.room.TypeConverter
import com.google.gson.Gson

class ResultCharacterTypeConverter {
    @TypeConverter
    fun LocationToString(location: Location): String = Gson().toJson(location)

    @TypeConverter
    fun stringToLocation(string: String): Location = Gson().fromJson(string, Location::class.java)

    @TypeConverter
    fun OriginToString(origin: Origin): String = Gson().toJson(origin)

    @TypeConverter
    fun stringToOrigin(string: String): Origin = Gson().fromJson(string, Origin::class.java)

    @TypeConverter
    fun FileToString(file: File): String = Gson().toJson(file)

    @TypeConverter
    fun stringToFile(string: String): File = Gson().fromJson(string, File::class.java)
}
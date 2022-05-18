package com.example.data.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.example.data.db.dao.CharactersDao
import com.example.data.db.dao.EpisodesDao
import com.example.data.db.dao.LocationsDao
import com.example.data.db.entity.character.EntityCharacter
import com.example.data.db.entity.episode.EntityEpisode
import com.example.data.db.entity.location.EntityLocation
import com.example.data.db.typeconverter.ResultCharacterTypeConverter
import com.example.data.db.typeconverter.ResultDefaultTypeConverter

@Database(entities = [EntityCharacter::class, EntityEpisode::class, EntityLocation::class], version = 3)
@TypeConverters(value = [ResultCharacterTypeConverter::class, ResultDefaultTypeConverter::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao

    abstract fun episodesDao(): EpisodesDao

    abstract fun locationsDao(): LocationsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase?  = null

     fun getDataBase(context: Context) :AppDataBase{
         val tInstance = INSTANCE
         if(tInstance !=null){
             return tInstance
         }
         synchronized(this){
             val inst = Room.databaseBuilder(
                 context.applicationContext,
                 AppDataBase::class.java,
                 "rick_and_morty").fallbackToDestructiveMigration().build()
             INSTANCE =inst
             return inst
         }
     }
    }


}

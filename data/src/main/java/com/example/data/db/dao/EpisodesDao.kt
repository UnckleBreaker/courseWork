package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.entity.episode.EntityEpisode
import com.example.data.db.entity.location.EntityLocation
import io.reactivex.Single

@Dao
interface EpisodesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodes(entityCharacter: EntityEpisode)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateEpisodes(entityCharacter: EntityEpisode)

    @Query("SELECT * FROM entity_episode_result")
    fun getAllEpisodes(): Single<List<EntityEpisode>>

    @Query("SELECT * FROM entity_episode_result WHERE name LIKE :search ")
    fun findEpisodes(search:String): Single<List<EntityEpisode>>
}
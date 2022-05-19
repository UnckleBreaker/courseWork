package com.example.data.db.rep


import com.example.data.db.entity.episode.EntityEpisode
import io.reactivex.Single

interface EpisodesRepositoryDb {

    fun getAllEpisodes() : Single<List<EntityEpisode>>

    fun InsertEpisodes(responce: EntityEpisode)

    fun UpdateEpisodes(responce: EntityEpisode)

    fun findEpisodes(search:String) : Single<List<EntityEpisode>>

    fun filterEpisodes(name: String, episode: String): Single<List<EntityEpisode>>
}
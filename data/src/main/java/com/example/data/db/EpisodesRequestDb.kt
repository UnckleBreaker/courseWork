package com.example.data.db

import android.content.Context
import com.example.data.db.entity.episode.EntityEpisode
import com.example.data.db.rep.EpisodesRepositoryDb
import com.example.data.db.entity.location.EntityLocation
import io.reactivex.Single

class EpisodesRequestDb(val context: Context) :EpisodesRepositoryDb {
    override fun getAllEpisodes(): Single<List<EntityEpisode>> {
        return AppDataBase.getDataBase(context).episodesDao().getAllEpisodes()
    }

    override fun InsertEpisodes(responce: EntityEpisode) {
         AppDataBase.getDataBase(context).episodesDao().insertEpisodes(responce)
    }

    override fun UpdateEpisodes(responce: EntityEpisode) {
        TODO("Not yet implemented")
    }

    override fun findEpisodes(search: String): Single<List<EntityEpisode>> {
        return AppDataBase.getDataBase(context).episodesDao().findEpisodes(search)
    }

    override fun filterEpisodes(name: String, episode: String): Single<List<EntityEpisode>> {
        return AppDataBase.getDataBase(context).episodesDao().filterEpisodes(name, episode)
    }
}
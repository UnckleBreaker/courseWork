package com.example.data.api.rep

import com.example.data.api.models.episode.ResponceEpisode
import com.example.data.api.models.episode.Result
import io.reactivex.Single

interface EpisodesRepositoryApi {
    fun getAllEpisodes() : Single<ResponceEpisode>

    fun getSomeEpisodes(ids:String) : Single<List<Result>>

    fun findEpisodes(search: String): Single<ResponceEpisode>
}
package com.example.data.api.rep

import com.example.data.models.episode.ResponceEpisode
import io.reactivex.Observable
import io.reactivex.Single

interface EpisodesRepositoryApi {
    fun getAllEpisodes() : Observable<ResponceEpisode>
}
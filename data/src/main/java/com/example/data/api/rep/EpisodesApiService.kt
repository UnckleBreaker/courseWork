package com.example.data.api.rep

import com.example.data.models.episode.ResponceEpisode
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface EpisodesApiService {
    @GET("api/episode")
    fun getAllEpisodes():Observable<ResponceEpisode>
}
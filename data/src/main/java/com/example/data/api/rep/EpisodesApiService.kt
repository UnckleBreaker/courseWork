package com.example.data.api.rep

import com.example.data.api.models.episode.ResponceEpisode
import com.example.data.api.models.episode.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodesApiService {
    @GET("api/episode")
    fun getAllEpisodes():Single<ResponceEpisode>

    @GET("api/episode/{ids}")
    fun getSomeEpisodes(@Path("ids") ids:String):Single<List<Result>>

    @GET("api/episode/?")
    fun findEpisode(@Query("name")search: String): Single<ResponceEpisode>
}
package com.example.data.api.rep

import com.example.data.api.models.episode.ResponceEpisode
import com.example.data.api.models.episode.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodesApiService {
    @GET("episode")
    fun getAllEpisodes():Single<ResponceEpisode>

    @GET("episode/{ids}")
    fun getSomeEpisodes(@Path("ids") ids:String):Single<List<Result>>

    @GET("episode/?")
    fun findEpisode(@Query("name")search: String): Single<ResponceEpisode>

    @GET("episode/?")
    fun filterEpisode(@Query("name")search: String,
                      @Query("episode")episode: String): Single<ResponceEpisode>
}
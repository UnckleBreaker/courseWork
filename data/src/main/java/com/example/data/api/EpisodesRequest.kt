package com.example.data.api

import com.example.data.api.constants.Const
import com.example.data.api.rep.EpisodesApiService
import com.example.data.api.rep.EpisodesRepositoryApi
import com.example.data.api.models.episode.ResponceEpisode
import com.example.data.api.models.episode.Result
import io.reactivex.Single

class EpisodesRequest() :EpisodesRepositoryApi {
    override fun getAllEpisodes(): Single<ResponceEpisode> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(EpisodesApiService::class.java).getAllEpisodes()
    }

    override fun getSomeEpisodes(ids: String): Single<List<Result>> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(EpisodesApiService::class.java).getSomeEpisodes(ids)
    }

    override fun findEpisodes(search: String): Single<ResponceEpisode> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(EpisodesApiService::class.java).findEpisode(search)
    }

    override fun filterEpisodes(name: String, episode: String): Single<ResponceEpisode> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(EpisodesApiService::class.java).filterEpisode(name,episode)
    }
}
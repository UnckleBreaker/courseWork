package com.example.data.api

import com.example.data.api.constants.Const
import com.example.data.api.rep.EpisodesApiService
import com.example.data.api.rep.EpisodesRepositoryApi
import com.example.data.models.episode.ResponceEpisode
import io.reactivex.Observable
import io.reactivex.Single

class EpisodesRequest :EpisodesRepositoryApi {
    override fun getAllEpisodes(): Observable<ResponceEpisode> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(EpisodesApiService::class.java).getAllEpisodes()
    }
}
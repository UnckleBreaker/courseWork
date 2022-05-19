package com.example.domain.usecases.byApi.get

import com.example.domain.model.episode.ResultEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetSomeEpisodesByApiUseCase(val repository: ApiRepository) {
    fun execute(ids:String): Single<List<ResultEpisodeDomain>> {
        return  repository.getSomeEpisodes(ids)
    }
}
package com.example.domain.usecases.byApi.get

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetEpisodesByApiUseCase(val repository: ApiRepository) {
    fun execute(): Single<ModelEpisodeDomain> {
       return repository.getEpisodes()
    }
}
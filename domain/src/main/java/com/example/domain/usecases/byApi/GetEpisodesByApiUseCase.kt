package com.example.domain.usecases.byApi

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Observable

class GetEpisodesByApiUseCase(val repository: ApiRepository) {
    fun execute(): Observable<ModelEpisodeDomain> {
       return repository.getEpisodes()
    }
}
package com.example.domain.usecases.byDb.get

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class GetEpisodesByDbUseCase(val repository: ApiRepository) {
    fun execute(): Single<ModelEpisodeDomain> {
        return repository.getEpisodesByDb()
    }
}
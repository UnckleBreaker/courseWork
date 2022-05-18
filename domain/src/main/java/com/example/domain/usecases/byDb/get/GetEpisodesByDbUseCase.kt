package com.example.domain.usecases.byDb.get

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Single

class GetEpisodesByDbUseCase(val repository: DbRepository) {
    fun execute(): Single<ModelEpisodeDomain> {
        return repository.getEpisodesByDb()
    }
}
package com.example.domain.usecases.byDb.filter

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class FilterEpisodesByDbiUseCase(val bdRepository: ApiRepository) {
    fun execute(name: String, episode: String): Single<ModelEpisodeDomain> {
        return bdRepository.filterEpisodesDb(name, episode)
    }
}
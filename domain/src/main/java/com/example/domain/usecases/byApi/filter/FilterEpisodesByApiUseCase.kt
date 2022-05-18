package com.example.domain.usecases.byApi.filter

import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class FilterEpisodesByApiUseCase(val apiRepository: ApiRepository) {

    fun execute(name: String, episode: String): Single<ModelEpisodeDomain> {
      return  apiRepository.filterEpisodes(name, episode)
    }
}
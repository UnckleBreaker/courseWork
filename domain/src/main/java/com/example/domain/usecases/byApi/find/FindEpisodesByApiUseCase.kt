package com.example.domain.usecases.byApi.find

import com.example.domain.repositories.ApiRepository

class FindEpisodesByApiUseCase(val repository: ApiRepository) {

    fun execute(search:String) = repository.findEpisodes(search)
}
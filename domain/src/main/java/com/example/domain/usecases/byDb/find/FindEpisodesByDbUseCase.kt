package com.example.domain.usecases.byDb.find

import com.example.domain.repositories.ApiRepository


class FindEpisodesByDbUseCase (val repository: ApiRepository) {

    fun execute(search:String) = repository.findEpisodesDb(search)
}
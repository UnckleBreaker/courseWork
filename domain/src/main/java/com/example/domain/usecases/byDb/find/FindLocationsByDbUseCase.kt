package com.example.domain.usecases.byDb.find

import com.example.domain.repositories.ApiRepository


class FindLocationsByDbUseCase(val apiRepository: ApiRepository) {
    fun execute(search:String) = apiRepository.findLocationsDb(search)
}
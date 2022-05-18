package com.example.domain.usecases.byDb.find

import com.example.domain.repositories.ApiRepository
import com.example.domain.repositories.DbRepository

class FindLocationsByDbUseCase(val apiRepository: DbRepository) {
    fun execute(search:String) = apiRepository.findLocationsDb(search)
}
package com.example.domain.usecases.byApi.find

import com.example.domain.repositories.ApiRepository

class FindLocationsByApiUseCase (val repository: ApiRepository) {

    fun execute(search:String) = repository.findLocations(search)
}
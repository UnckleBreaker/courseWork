package com.example.domain.usecases.byApi.find

import com.example.domain.repositories.ApiRepository

class FindCharactersByApiUseCase (val repository: ApiRepository) {

    fun execute(search:String) = repository.findCharacters(search)
}
package com.example.domain.usecases.byApi.get

import com.example.domain.repositories.ApiRepository

class GetSomeCharactersByApiUseCase (val repository: ApiRepository) {
    fun execute(ids:String) =repository.getSomeCharacters(ids)
}
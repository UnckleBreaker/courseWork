package com.example.domain.usecases.byApi

import com.example.domain.repositories.ApiRepository

class GetCharacktersByApiUseCase(val repository: ApiRepository) {

    fun execute() = repository.getCharacters()
}
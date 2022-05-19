package com.example.domain.usecases.byDb.find

import com.example.domain.repositories.ApiRepository


class FindCharactersByDbUseCase (val repository: ApiRepository) {

    fun execute(search:String) = repository.findCharactersDb(search)
}
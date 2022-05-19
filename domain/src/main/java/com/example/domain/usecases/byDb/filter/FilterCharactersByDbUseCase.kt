package com.example.domain.usecases.byDb.filter

import com.example.domain.repositories.ApiRepository

class FilterCharactersByDbUseCase(val apiRepository: ApiRepository) {
    fun execute(status: String,
                spicies: String,
                gender: String,
                type: String) =
        apiRepository.filterCharactersDb(status, spicies, gender, type)
}
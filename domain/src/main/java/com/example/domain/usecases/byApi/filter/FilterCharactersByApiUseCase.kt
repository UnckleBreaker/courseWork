package com.example.domain.usecases.byApi.filter

import com.example.domain.repositories.ApiRepository

class FilterCharactersByApiUseCase(val apiRepository: ApiRepository) {
    fun execute(status: String,
                spicies: String,
                gender: String,
                type: String) =
        apiRepository.filterCharacters(status, spicies, gender, type)
}
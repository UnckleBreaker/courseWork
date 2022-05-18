package com.example.domain.usecases.byDb.filter

import com.example.domain.repositories.ApiRepository
import com.example.domain.repositories.DbRepository

class FilterCharactersByDbUseCase(val dbRepository: DbRepository) {
    fun execute(status: String,
                spicies: String,
                gender: String,
                type: String) =
        dbRepository.filterCharactersDb(status, spicies, gender, type)
}
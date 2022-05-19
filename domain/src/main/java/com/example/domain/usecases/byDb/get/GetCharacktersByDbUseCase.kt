package com.example.domain.usecases.byDb.get

import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class GetCharacktersByDbUseCase(val repository: ApiRepository) {
    fun execute(): Single<ModelCharacterDomain> {
       return  repository.getCharactersByDb()
    }
}
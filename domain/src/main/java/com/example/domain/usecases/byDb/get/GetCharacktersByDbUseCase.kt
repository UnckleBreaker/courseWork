package com.example.domain.usecases.byDb.get

import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Single

class GetCharacktersByDbUseCase(val repository: DbRepository) {
    fun execute(): Single<ModelCharacterDomain> {
       return  repository.getCharactersByDb()
    }
}
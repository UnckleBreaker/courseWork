package com.example.domain.usecases.byDb.get

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Single

class GetLocationsByDbUseCase(val repository: DbRepository) {
    fun execute(): Single<ModelLocationsDomain> {
    return repository.getLocationsByDb()
    }
}
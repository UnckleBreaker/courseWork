package com.example.domain.usecases.byDb.get

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class GetLocationsByDbUseCase(val repository: ApiRepository) {
    fun execute(): Single<ModelLocationsDomain> {
    return repository.getLocationsByDb()
    }
}
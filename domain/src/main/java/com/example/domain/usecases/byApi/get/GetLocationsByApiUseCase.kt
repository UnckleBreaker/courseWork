package com.example.domain.usecases.byApi.get

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetLocationsByApiUseCase(val repository: ApiRepository) {
    fun execute(): Single<ModelLocationsDomain> {
       return  repository.getLocations()
    }
}
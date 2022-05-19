package com.example.domain.usecases.byApi.get

import com.example.domain.model.locations.ResultLocationsDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetSomeLocationsByApiUseCase(val repository: ApiRepository) {
    fun execute(url:String): Single<ResultLocationsDomain> {
        return repository.getOneLocations(url)
    }
}
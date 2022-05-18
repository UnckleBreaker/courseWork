package com.example.domain.usecases.byApi.filter

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class FilterLocationsByApiUseCase(val apiRepository: ApiRepository) {

    fun execute(name: String, type: String, demension: String): Single<ModelLocationsDomain> {
      return  apiRepository.filterLocations(name, type, demension)
    }
}
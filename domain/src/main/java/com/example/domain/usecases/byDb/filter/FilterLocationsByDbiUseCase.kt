package com.example.domain.usecases.byDb.filter

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.ApiRepository
import io.reactivex.Single

class FilterLocationsByDbiUseCase(val apiRepository: ApiRepository) {
    fun execute(name: String, type: String, demension: String): Single<ModelLocationsDomain> {
        return apiRepository.filterLocationsDb(name, type, demension)
    }
}
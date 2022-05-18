package com.example.domain.usecases.byDb.filter

import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Single

class FilterLocationsByDbiUseCase(val dbRepository: DbRepository) {
    fun execute(name: String, type: String, demension: String): Single<ModelLocationsDomain> {
        return dbRepository.filterLocationsDb(name, type, demension)
    }
}
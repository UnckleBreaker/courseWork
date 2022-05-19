package com.example.data.mappers.location

import com.example.data.db.entity.location.EntityLocation
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.locations.ResultLocationsDomain

object LocationsToEntityMapper :DataToDomainMapper<ResultLocationsDomain,EntityLocation> {
    override fun map(it: ResultLocationsDomain): EntityLocation {
        return EntityLocation(it.created,it.dimension,
            it.id,it.name,it.residents,it.type,it.url)
    }
}
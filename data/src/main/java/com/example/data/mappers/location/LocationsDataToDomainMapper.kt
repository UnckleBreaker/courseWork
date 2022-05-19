package com.example.data.mappers.location

import com.example.domain.model.locations.Info
import com.example.data.api.models.location.ResponceLocations
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.model.locations.ResultLocationsDomain

object LocationsDataToDomainMapper : DataToDomainMapper<ResponceLocations, ModelLocationsDomain> {
    override fun map(from: ResponceLocations): ModelLocationsDomain {
        return from.let {
            ModelLocationsDomain(info = Info(it.info.next,it.info.prev),
            results = it.results.map { ResultLocationsDomain(it.created,it.dimension,it.id,it.name,it.residents,it.type,it.url) })
        }
    }
}
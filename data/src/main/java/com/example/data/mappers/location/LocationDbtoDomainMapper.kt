package com.example.data.mappers.location

import com.example.data.db.entity.location.EntityLocation
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.model.locations.ResultLocationsDomain

object LocationDbtoDomainMapper :DataToDomainMapper<List<EntityLocation>,ModelLocationsDomain> {
    override fun map(from: List<EntityLocation>): ModelLocationsDomain {
        return ModelLocationsDomain(null, from.map {
            ResultLocationsDomain(it.created,it.dimension,
                it.id,it.name,it.residents,it.type,it.url)
        })
    }
}


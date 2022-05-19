package com.example.coursework.mappers

import com.example.app.mappers.DomainToAppMapper
import com.example.coursework.model.location.ResultLocation
import com.example.domain.model.locations.ResultLocationsDomain

object OneLocationDomainToAppMapper : DomainToAppMapper<ResultLocationsDomain,ResultLocation> {
    override fun map(from: ResultLocationsDomain): ResultLocation {
        return from.let {
            ResultLocation(it.created,it.dimension,it.id,it.name,it.residents,it.type,it.url)
        }
    }
}
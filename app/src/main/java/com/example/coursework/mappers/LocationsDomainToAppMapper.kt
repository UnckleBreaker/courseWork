package com.example.coursework.mappers

import com.example.app.mappers.DomainToAppMapper
import com.example.coursework.model.location.Info
import com.example.coursework.model.location.ModelLocationsApp
import com.example.coursework.model.location.ResultLocation
import com.example.domain.model.locations.ModelLocationsDomain

object LocationsDomainToAppMapper : DomainToAppMapper<ModelLocationsDomain,ModelLocationsApp> {
    override fun map(from: ModelLocationsDomain): ModelLocationsApp {
        return from.let {
            ModelLocationsApp(info = Info(it.info?.next,it.info?.prev),
                results = it.results.map { ResultLocation(it.created,it.dimension,it.id,it.name,it.residents,it.type,it.url) })
        }
    }
}
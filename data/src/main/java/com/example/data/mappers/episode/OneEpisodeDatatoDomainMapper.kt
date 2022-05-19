package com.example.data.mappers.episode

import com.example.data.api.models.episode.Result
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.episode.ResultEpisodeDomain

object OneEpisodeDatatoDomainMapper : DataToDomainMapper<List<Result>, List<ResultEpisodeDomain>> {
    override fun map(from: List<Result>): List<ResultEpisodeDomain> {
        var list = mutableListOf<ResultEpisodeDomain>()
        from.forEach {
            list.add(ResultEpisodeDomain(it.air_date,it.characters,it.created,it.episode
                ,it.id,it.name,it.url))
        }
        return list
    }
}
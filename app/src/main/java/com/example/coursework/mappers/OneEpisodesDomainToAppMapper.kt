package com.example.coursework.mappers

import com.example.app.mappers.DomainToAppMapper
import com.example.coursework.model.episode.ResultEpisode
import com.example.domain.model.episode.ResultEpisodeDomain

object OneEpisodesDomainToAppMapper :DomainToAppMapper<List<ResultEpisodeDomain>,List<ResultEpisode>> {
    override fun map(from: List<ResultEpisodeDomain>): List<ResultEpisode> {
        var list = mutableListOf<ResultEpisode>()
        from.forEach {
            list.add(ResultEpisode(it.air_date,it.characters,it.created,it.episode
                ,it.id,it.name,it.url))
        }
        return list
    }
}
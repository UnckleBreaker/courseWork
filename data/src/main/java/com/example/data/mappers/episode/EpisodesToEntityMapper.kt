package com.example.data.mappers.episode

import com.example.data.db.entity.episode.EntityEpisode
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.episode.ResultEpisodeDomain

object EpisodesToEntityMapper :DataToDomainMapper<ResultEpisodeDomain,EntityEpisode> {
    override fun map(it: ResultEpisodeDomain): EntityEpisode {
        return EntityEpisode(it.air_date,it.characters,it.created,it.episode
            ,it.id,it.name,it.url)
    }
}
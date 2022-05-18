package com.example.data.mappers.episode

import com.example.data.db.entity.episode.EntityEpisode
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.episode.ResultEpisodeDomain

object EpisodesEntityToDomain :DataToDomainMapper<List<EntityEpisode>,ModelEpisodeDomain> {
    override fun map(from: List<EntityEpisode>): ModelEpisodeDomain {
        return ModelEpisodeDomain(null,from.map {
            ResultEpisodeDomain(it.air_date,it.characters,it.created,it.episode
                ,it.id,it.name,it.url)
        })
    }
}
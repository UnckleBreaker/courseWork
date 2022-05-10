package com.example.coursework.mappers

import com.example.app.mappers.DomainToAppMapper
import com.example.coursework.model.episode.Info


import com.example.coursework.model.episode.ModelEpisodeApp
import com.example.coursework.model.episode.Result
import com.example.domain.model.episode.ModelEpisodeDomain

object EpisodesDomainToAppMapper : DomainToAppMapper<ModelEpisodeDomain, ModelEpisodeApp> {

    override fun map(from: ModelEpisodeDomain): ModelEpisodeApp {
        return from.let {
          ModelEpisodeApp(info =  Info(it.info.next,it.info.prev),
          results = it.results.map { Result(it.air_date,it.characters, it.created
              ,it.episode,it.id,it.name,it.url) })
        }
    }
}
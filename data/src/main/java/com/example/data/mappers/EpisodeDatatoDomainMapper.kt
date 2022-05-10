package com.example.data.mappers


import com.example.data.models.episode.ResponceEpisode
import com.example.domain.model.episode.Info
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.episode.Result

object EpisodeDatatoDomainMapper : DataToDomainMapper<ResponceEpisode, ModelEpisodeDomain>{

    override fun map(from: ResponceEpisode): ModelEpisodeDomain {
        return from.let {
            ModelEpisodeDomain(info = Info(it.info.next,it.info.prev),
                results = it.results.map { Result(it.air_date,it.characters, it.created
                    ,it.episode,it.id,it.name,it.url) })
        }
    }
}
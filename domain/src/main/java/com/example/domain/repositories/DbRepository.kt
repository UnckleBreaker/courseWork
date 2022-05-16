package com.example.domain.repositories

import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.locations.ModelLocationsDomain
import io.reactivex.Single

interface DbRepository {

    fun getCharactersByDb (): Single<ModelCharacterDomain>

    fun getEpisodesByDb() : Single<ModelEpisodeDomain>

    fun getLocationsByDb() : Single<ModelLocationsDomain>
}
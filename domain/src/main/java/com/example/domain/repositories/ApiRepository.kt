package com.example.domain.repositories

import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.character.ResultCharcterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.episode.ResultEpisodeDomain
import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.model.locations.ResultLocationsDomain
import io.reactivex.Observable
import io.reactivex.Single


interface ApiRepository {
    fun getCharacters(): Single<ModelCharacterDomain>

    fun getEpisodes(): Single<ModelEpisodeDomain>

    fun getLocations(): Single<ModelLocationsDomain>

    fun getSomeEpisodes(ids: String): Single<List<ResultEpisodeDomain>>

    fun getSomeCharacters(ids: String): Single<List<ResultCharcterDomain>>

    fun getOneLocations(url: String): Single<ResultLocationsDomain>

    fun findCharacters(search: String): Single<ModelCharacterDomain>

    fun findEpisodes(search: String): Single<ModelEpisodeDomain>

    fun findLocations(search: String): Single<ModelLocationsDomain>

    fun filterCharacters(
        status: String,
        spicies: String,
        gender: String,
        type: String,
    ): Single<ModelCharacterDomain>

    fun filterEpisodes(name: String, episode: String): Single<ModelEpisodeDomain>

    fun filterLocations(name: String, type: String, demension: String): Single<ModelLocationsDomain>
}
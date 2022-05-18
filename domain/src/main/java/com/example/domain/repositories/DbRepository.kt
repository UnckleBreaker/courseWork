package com.example.domain.repositories

import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.locations.ModelLocationsDomain
import io.reactivex.Single

interface DbRepository {

    fun getCharactersByDb (): Single<ModelCharacterDomain>

    fun getEpisodesByDb() : Single<ModelEpisodeDomain>

    fun getLocationsByDb() : Single<ModelLocationsDomain>

    fun findCharactersDb(search:String):Single<ModelCharacterDomain>

    fun findEpisodesDb(search:String):Single<ModelEpisodeDomain>

    fun findLocationsDb(search:String):Single<ModelLocationsDomain>

    fun filterCharactersDb( status: String,
                             spicies: String,
                             gender: String,
                             type: String,):Single<ModelCharacterDomain>

//    fun filterEpisodesDb(search:String):Single<ModelEpisodeDomain>
//
//    fun filterLocationsDb(search:String):Single<ModelLocationsDomain>


}
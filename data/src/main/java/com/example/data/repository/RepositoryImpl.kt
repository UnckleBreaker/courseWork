package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.data.api.rep.CharacterRepositoryApi
import com.example.data.api.rep.EpisodesRepositoryApi
import com.example.data.api.rep.LocationsRepositoryApi
import com.example.data.db.rep.CharactersRepositoryDb
import com.example.data.db.rep.EpisodesRepositoryDb
import com.example.data.db.rep.LocationsRepositoryDb
import com.example.data.mappers.character.CharactersDataToDomainMapper
import com.example.data.mappers.character.CharactersDataToEntityMapper
import com.example.data.mappers.character.CharactersDbDataToDomainMapper
import com.example.data.mappers.character.OneCharacterDatatoDomainMapper
import com.example.data.mappers.episode.EpisodeDatatoDomainMapper
import com.example.data.mappers.episode.EpisodesEntityToDomain
import com.example.data.mappers.episode.EpisodesToEntityMapper
import com.example.data.mappers.episode.OneEpisodeDatatoDomainMapper
import com.example.data.mappers.location.LocationDbtoDomainMapper
import com.example.data.mappers.location.LocationsDataToDomainMapper
import com.example.data.mappers.location.LocationsToEntityMapper
import com.example.data.mappers.location.OneLocationDatatoDomainMapper
import com.example.domain.repositories.ApiRepository
import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.character.ResultCharcterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.model.episode.ResultEpisodeDomain
import com.example.domain.model.locations.ModelLocationsDomain
import com.example.domain.model.locations.ResultLocationsDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Single

class RepositoryImpl(
    val context: Context,
    val characterApi: CharacterRepositoryApi?,
    val episodeApi: EpisodesRepositoryApi?,
    val locationApi: LocationsRepositoryApi?,
    val characterDb: CharactersRepositoryDb?,
    val locationDb: LocationsRepositoryDb?,
    val episodesDb: EpisodesRepositoryDb?
) : ApiRepository, DbRepository {

    override fun getCharacters(): Single<ModelCharacterDomain> {
        return characterApi!!.getAllCharacters().map { CharactersDataToDomainMapper(context).map(it) .also { saveCharacters(it.results) }
        }
    }
    fun saveEpisodes(episode: List<ResultEpisodeDomain>){
        episode.forEach { episodesDb!!.InsertEpisodes(EpisodesToEntityMapper.map(it))}
    }
    fun saveCharacters(character:List<ResultCharcterDomain>){
        character.forEach {  characterDb!!.InsertCharacters(CharactersDataToEntityMapper(context).map(it))}
    }

    override fun getEpisodes(): Single<ModelEpisodeDomain> {
        return episodeApi!!.getAllEpisodes()
            .map { EpisodeDatatoDomainMapper.map(it).also { saveEpisodes(it.results)}
            }
    }

    override fun getLocations(): Single<ModelLocationsDomain> {
        return locationApi!!.getAllLocations()
            .map { LocationsDataToDomainMapper.map(it)
                    .also {
                        it.results.forEach { locationDb!!.InsertLocations(LocationsToEntityMapper.map(it)) }
                    }
            }
    }

    override fun getSomeEpisodes(ids: String): Single<List<ResultEpisodeDomain>> {
        return episodeApi!!.getSomeEpisodes(ids)
            .map { OneEpisodeDatatoDomainMapper.map(it)}
    }

    override fun getSomeCharacters(ids: String): Single<List<ResultCharcterDomain>> {
        return characterApi!!.getSomeCharacters(ids)
            .map { OneCharacterDatatoDomainMapper(context).map(it) }
    }

    override fun getOneLocations(url: String): Single<ResultLocationsDomain> {
        return locationApi!!.getOneLocation(url)
            .map { OneLocationDatatoDomainMapper.map(it) }
    }

    override fun findCharacters(search: String): Single<ModelCharacterDomain> {
        return characterApi!!.findCharacters(search)
            .map { CharactersDataToDomainMapper(context).map(it) }

    }

    override fun findCharactersDb(search: String): Single<ModelCharacterDomain> {
        return characterDb!!.findCharacters(search).map {
            CharactersDbDataToDomainMapper(context).map(it)
        }
    }

    override fun findEpisodesDb(search: String): Single<ModelEpisodeDomain> {
        return episodesDb!!.findEpisodes(search = search).map {
            EpisodesEntityToDomain.map(it)
        }
    }

    override fun findLocationsDb(search: String): Single<ModelLocationsDomain> {
        return locationDb!!.findLocations(search = search).map {
            LocationDbtoDomainMapper.map(it)
        }
    }

    override fun findEpisodes(search: String): Single<ModelEpisodeDomain> {
        return episodeApi!!.findEpisodes(search)
            .map { EpisodeDatatoDomainMapper.map(it) }
    }

    override fun findLocations(search: String): Single<ModelLocationsDomain> {
        return locationApi!!.findLocations(search)
            .map { LocationsDataToDomainMapper.map(it) }
    }

    override fun getCharactersByDb(): Single<ModelCharacterDomain> {
        return characterDb!!.getAllCharacters()
            .map { CharactersDbDataToDomainMapper(context).map(it) }
    }

    override fun getEpisodesByDb(): Single<ModelEpisodeDomain> {
        return episodesDb!!.getAllEpisodes()
            .map { EpisodesEntityToDomain.map(it) }

    }

    override fun getLocationsByDb(): Single<ModelLocationsDomain> {
        return locationDb!!.getAllLocations().map {
            LocationDbtoDomainMapper.map(it)
        }
    }

    override fun filterCharacters(
        status: String,
        spicies: String,
        gender: String,
        type: String,
    ): Single<ModelCharacterDomain> {
        return characterApi!!.filterCharacters(status, spicies, gender, type).map {
            CharactersDataToDomainMapper(context).map(it)
        }
    }

    override fun filterEpisodes(name: String, episode: String): Single<ModelEpisodeDomain> {
        return episodeApi!!.filterEpisodes(name, episode)
            .map { EpisodeDatatoDomainMapper.map(it) }
    }

    override fun filterLocations(
        name: String,
        type: String,
        demension: String
    ): Single<ModelLocationsDomain> {
        return locationApi!!.filterLocations(name, type, demension).map {
            LocationsDataToDomainMapper.map(it)
        } }

    override fun filterCharactersDb(
        status: String,
        spicies: String,
        gender: String,
        type: String,
    ): Single<ModelCharacterDomain> {
        return characterDb!!.filterCharacters(status, spicies, gender, type).map {
            CharactersDbDataToDomainMapper(context).map(it)
        }
    }

    override fun filterEpisodesDb(name: String, episode: String): Single<ModelEpisodeDomain> {
        return episodesDb!!.filterEpisodes(name, episode).map {
            EpisodesEntityToDomain.map(it) }
    }

    override fun filterLocationsDb(
        name: String,
        type: String,
        demension: String
    ): Single<ModelLocationsDomain> {
        return locationDb!!.filterLocations(name, type, demension).map {
            LocationDbtoDomainMapper.map(it)
        }
    }
}
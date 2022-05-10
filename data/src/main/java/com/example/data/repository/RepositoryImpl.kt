package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.data.api.rep.CharacterRepositoryApi
import com.example.data.api.rep.EpisodesRepositoryApi
import com.example.data.mappers.CharactersDataToDomainMapper
import com.example.data.mappers.EpisodeDatatoDomainMapper
import com.example.data.models.episode.ResponceEpisode
import com.example.domain.repositories.ApiRepository
import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import com.example.domain.repositories.DbRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.observers.DisposableObserver


class RepositoryImpl(
    val context: Context,
    val repositoryApi: CharacterRepositoryApi,
    val episodeApi: EpisodesRepositoryApi
) : ApiRepository, DbRepository {

    lateinit var dataToShow: ModelCharacterDomain

    override fun getCharacters(): Observable<ModelCharacterDomain> {
        return repositoryApi.getAllCharacters()
            .map { CharactersDataToDomainMapper(context).map(it) }

    }

    override fun getEpisodes(): Observable<ModelEpisodeDomain> {
       return episodeApi.getAllEpisodes()
            .map { EpisodeDatatoDomainMapper.map(it) }


    }

    private fun returnData(): ModelCharacterDomain {
        return dataToShow

    }

    private fun handelError(throwable: Throwable?) {
        Log.e("RepositoryImpl", "handelError: ${throwable?.message} ")
    }

    private fun handleData(response: ModelCharacterDomain) {
        dataToShow = response
        Log.e("RepositoryImpl", "handleData: $response ")

    }

}
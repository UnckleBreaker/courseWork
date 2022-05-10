package com.example.domain.repositories
import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.model.episode.ModelEpisodeDomain
import io.reactivex.Observable


interface ApiRepository  {
    fun getCharacters(): Observable<ModelCharacterDomain>

    fun getEpisodes() : Observable<ModelEpisodeDomain>
}
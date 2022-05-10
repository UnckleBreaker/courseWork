package com.example.data.api.rep

import com.example.data.models.character.ResponceCharacters
import io.reactivex.Observable
import io.reactivex.Single


interface CharacterRepositoryApi {
    fun getAllCharacters() : Observable<ResponceCharacters>
}
package com.example.data.api.rep

import com.example.data.api.models.character.ResponceCharacters
import com.example.data.api.models.character.Result
import io.reactivex.Single


interface CharacterRepositoryApi {
    fun getAllCharacters() : Single<ResponceCharacters>

    fun getSomeCharacters(ids:String) : Single<List<Result>>

    fun findCharacters(search:String) : Single<ResponceCharacters>

    fun filterCharacters( status: String,
                           spicies: String,
                           gender: String,
                           type: String):Single<ResponceCharacters>
}
package com.example.data.api

import com.example.data.api.constants.Const
import com.example.data.api.rep.CharacterApiService
import com.example.data.api.rep.CharacterRepositoryApi
import com.example.data.models.character.ResponceCharacters
import io.reactivex.Observable
import io.reactivex.Single

class CharactersRequest : CharacterRepositoryApi {

    override fun getAllCharacters(): Observable<ResponceCharacters> {
       return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(CharacterApiService::class.java)
            .getAllCharacters()
    }

}
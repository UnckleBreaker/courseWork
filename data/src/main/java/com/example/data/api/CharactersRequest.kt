package com.example.data.api

import com.example.data.api.constants.Const
import com.example.data.api.rep.CharacterApiService
import com.example.data.api.rep.CharacterRepositoryApi
import com.example.data.api.models.character.ResponceCharacters
import com.example.data.api.models.character.Result
import io.reactivex.Single

class CharactersRequest : CharacterRepositoryApi {

    override fun getAllCharacters(): Single<ResponceCharacters> {
       return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(CharacterApiService::class.java)
            .getAllCharacters()
    }

    override fun getSomeCharacters(ids: String): Single<List<Result>> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(CharacterApiService::class.java)
            .getSomeCharacters(ids)
    }

    override fun findCharacters(search: String): Single<ResponceCharacters> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(CharacterApiService::class.java)
            .findCharacters(search)
    }

}
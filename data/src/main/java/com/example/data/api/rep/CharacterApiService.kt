package com.example.data.api.rep

import com.example.data.api.models.character.ResponceCharacters
import com.example.data.api.models.character.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("api/character")
    fun getAllCharacters():Single<ResponceCharacters>

    @GET("api/character/{ids}")
    fun getSomeCharacters(@Path("ids") ids: String): Single<List<Result>>

    @GET("api/character/?")
    fun findCharacters(@Query("name") search: String): Single<ResponceCharacters>
}
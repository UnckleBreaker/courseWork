package com.example.data.api.rep

import com.example.data.api.models.character.ResponceCharacters
import com.example.data.api.models.character.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CharacterApiService {
    @GET("character")
    fun getAllCharacters():Single<ResponceCharacters>

    @GET("character/{ids}")
    fun getSomeCharacters(@Path("ids") ids: String): Single<List<Result>>

    @GET("character/?")
    fun findCharacters(@Query("name") search: String): Single<ResponceCharacters>

    @GET("character/?")
    fun filterCharacters(@Query("status") status: String,
                         @Query("species") species: String,
                         @Query("type") type: String,
                         @Query("gender") gender: String): Single<ResponceCharacters>
}
package com.example.data.api.rep

import com.example.data.models.character.ResponceCharacters
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface CharacterApiService {
    @GET("api/character")
    fun getAllCharacters():Observable<ResponceCharacters>
}
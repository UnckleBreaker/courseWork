package com.example.data.api.rep

import com.example.data.api.models.location.ResponceLocations
import com.example.data.api.models.location.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationsApiService {
    @GET("api/location")
    fun getAllLocations(): Single<ResponceLocations>

    @GET("api/location/{id}")
    fun getOneLocation(@Path("id") id:String):Single<Result>

    @GET("api/location/?")
    fun findLocations(@Query("name") search: String): Single<ResponceLocations>
}
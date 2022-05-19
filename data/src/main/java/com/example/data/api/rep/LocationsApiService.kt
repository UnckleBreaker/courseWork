package com.example.data.api.rep

import com.example.data.api.models.location.ResponceLocations
import com.example.data.api.models.location.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationsApiService {
    @GET("location")
    fun getAllLocations(): Single<ResponceLocations>

    @GET("location/{id}")
    fun getOneLocation(@Path("id") id:String):Single<Result>

    @GET("location/?")
    fun findLocations(@Query("name") search: String): Single<ResponceLocations>

    @GET("location/?")
    fun filterLocations(@Query("name",) search: String,
                        @Query("type",) type: String,
                        @Query("dimension",) dimension: String): Single<ResponceLocations>
}
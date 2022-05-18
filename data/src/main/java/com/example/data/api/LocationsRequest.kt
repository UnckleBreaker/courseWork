package com.example.data.api

import com.example.data.api.constants.Const
import com.example.data.api.rep.LocationsApiService
import com.example.data.api.rep.LocationsRepositoryApi
import com.example.data.api.models.location.ResponceLocations
import com.example.data.api.models.location.Result
import io.reactivex.Single

class LocationsRequest : LocationsRepositoryApi {
    override fun getAllLocations(): Single<ResponceLocations> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(LocationsApiService::class.java).getAllLocations()
    }

    override fun getOneLocation(id:String): Single<Result> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(LocationsApiService::class.java).getOneLocation(id)
    }

    override fun findLocations(search: String): Single<ResponceLocations> {
        return ApiBuilder.retrofitBuilder(Const.baseUrl)
            .create(LocationsApiService::class.java).findLocations(search)
    }
}
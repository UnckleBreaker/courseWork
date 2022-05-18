package com.example.data.api.rep

import com.example.data.api.models.location.ResponceLocations
import com.example.data.api.models.location.Result
import io.reactivex.Single

interface LocationsRepositoryApi {
    fun getAllLocations() : Single<ResponceLocations>

    fun getOneLocation(id:String): Single<Result>

    fun findLocations(search:String) : Single<ResponceLocations>

    fun filterLocations(name: String, type: String, demension: String): Single<ResponceLocations>
}
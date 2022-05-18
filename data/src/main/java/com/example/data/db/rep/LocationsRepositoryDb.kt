package com.example.data.db.rep

import com.example.data.db.entity.location.EntityLocation
import io.reactivex.Single

interface LocationsRepositoryDb {

    fun getAllLocations() :Single<List<EntityLocation>>

    fun InsertLocations(responce: EntityLocation)

    fun UpdateLocations(responce: EntityLocation)

    fun findLocations(search:String) : Single<List<EntityLocation>>

    fun filterLocations(name: String,
                        type: String,
                        demension: String): Single<List<EntityLocation>>
}
package com.example.data.db

import android.content.Context
import com.example.data.db.entity.location.EntityLocation
import com.example.data.db.rep.LocationsRepositoryDb
import io.reactivex.Single

class LocationsRequestDb(val context: Context) : LocationsRepositoryDb {
    override fun getAllLocations(): Single<List<EntityLocation>> {
        return AppDataBase.getDataBase(context).locationsDao().getAllLocations()
    }

    override fun InsertLocations(responce: EntityLocation) {
        AppDataBase.getDataBase(context).locationsDao().insertLocations(responce)
    }

    override fun UpdateLocations(responce: EntityLocation) {
        TODO("Not yet implemented")
    }

    override fun findLocations(search: String): Single<List<EntityLocation>>{
      return  AppDataBase.getDataBase(context).locationsDao().findLocations(search)
    }
}
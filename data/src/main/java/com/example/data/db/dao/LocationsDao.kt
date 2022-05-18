package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.entity.location.EntityLocation
import io.reactivex.Single

@Dao
interface LocationsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocations(entityCharacter: EntityLocation)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateLocations(entityCharacter: EntityLocation)

    @Query("SELECT * FROM entity_location_result")
    fun getAllLocations(): Single<List<EntityLocation>>

    @Query("SELECT * FROM entity_location_result WHERE name LIKE :search ")
    fun findLocations(search:String): Single<List<EntityLocation>>

    @Query("SELECT * FROM entity_location_result WHERE (:name IS NULL OR name LIKE '%' || :name || '%' AND (:type is NULL OR type LIKE '%' || :type || '%' AND (:demension IS NULL OR dimension LIKE '%' || :demension || '%' )))")
    fun filterLocations(  name: String,
                          type: String,
                          demension: String): Single<List<EntityLocation>>
}
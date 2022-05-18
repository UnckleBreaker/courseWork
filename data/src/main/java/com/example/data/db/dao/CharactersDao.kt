package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.entity.character.EntityCharacter
import io.reactivex.Single

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(entityCharacter: EntityCharacter)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCharacters(entityCharacter: EntityCharacter)

    @Query("SELECT * FROM entity_character_result")
    fun getAllCharacters(): Single<List<EntityCharacter>>

    @Query("SELECT * FROM entity_character_result WHERE name LIKE :search  ")
    fun findCharacters(search:String) : Single<List<EntityCharacter>>

    @Query("SELECT * FROM entity_character_result WHERE status LIKE :status " +
            "AND species LIKE :species " +
            "AND gender LIKE :gender " +
            "AND type LIKE :type")
    fun filterCharactersType(status: String, species: String, gender: String, type: String) : Single<List<EntityCharacter>>

    @Query("SELECT * FROM entity_character_result WHERE status IS :status AND gender IS :gender " )
    fun filterCharacters(status: String, gender: String): Single<List<EntityCharacter>>

}
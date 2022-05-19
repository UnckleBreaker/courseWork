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

    @Query("SELECT * FROM entity_character_result WHERE (:status IS NULL OR status LIKE '%' || :status || '%' AND (:species is NULL OR species LIKE '%' || :species || '%' AND (:gender IS NULL OR gender LIKE '%' || :gender || '%' AND (:type IS NULL OR gender LIKE '%' || :gender || '%'))))")
    fun filterCharactersType(status: String, species: String, gender: String, type: String) : Single<List<EntityCharacter>>

    @Query("SELECT * FROM entity_character_result WHERE (:status IS NULL OR status LIKE '%' || :status || '%' AND (:gender IS NULL OR gender LIKE '%' || :gender || '%'))")
    fun filterCharacters(status: String, gender: String): Single<List<EntityCharacter>>

}
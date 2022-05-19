package com.example.data.db.rep

import com.example.data.db.entity.character.EntityCharacter

import io.reactivex.Single

interface CharactersRepositoryDb {

    fun getAllCharacters() :Single<List<EntityCharacter>>

    fun InsertCharacters(responce:EntityCharacter)

    fun UpdateCharacters(responce:EntityCharacter)

    fun findCharacters(search:String) : Single<List<EntityCharacter>>

    fun filterCharacters(status: String,
                         spicies: String,
                         gender: String,
                         type: String): Single<List<EntityCharacter>>

}
package com.example.data.db

import android.content.Context
import com.example.data.db.entity.character.EntityCharacter
import com.example.data.db.rep.CharactersRepositoryDb
import io.reactivex.Single

//class CharactersRequestDb(val context: Context) : CharactersRepositoryDb {
//    override fun getAllCharacters(): Single<List<EntityCharacter>> {
//        return AppDataBase.getDataBase(context).charactersDao().getAllCharacters()
//    }
//
//    override fun InsertCharacters(responce: EntityCharacter) {
//        AppDataBase.getDataBase(context).charactersDao().insertCharacters(responce)
//    }
//
//    override fun UpdateCharacters(responce: EntityCharacter) {
//        TODO("Not yet implemented")
//    }
//
//    override fun findCharacters(search: String): Single<List<EntityCharacter>> {
//        return AppDataBase.getDataBase(context).charactersDao().findCharacters(search)
//    }
//
//    override fun filterCharacters(
//        status: String,
//        spicies: String,
//        gender: String,
//        type: String
//    ): Single<List<EntityCharacter>> {
//        return AppDataBase.getDataBase(context).charactersDao()
//            .filterCharactersType(status, spicies, gender, type)
//    }
//}
package com.example.data.mappers

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.data.models.character.ResponceCharacters
import com.example.domain.model.character.*
import java.io.File

@GlideModule
class CharactersDataToDomainMapper(val context: Context) : DataToDomainMapper<ResponceCharacters,ModelCharacterDomain>,AppGlideModule(){

    override fun map(from: ResponceCharacters): ModelCharacterDomain {
        return from.let { it ->
            ModelCharacterDomain(Info( next = it.info.next,
                pages = it.info.pages,),
                results =it.results.map { Result(it.created,it.episode,it.gender,
                    it.id, covertToBitMap(it.image),Location(it.location.name,it.location.url),it.name,
                    Origin(it.origin.name,it.origin.url),it.species,it.status,it.type,it.url) })
        }
    }

    fun covertToBitMap(url: String): File {
        return Glide
            .with(context)
            .asFile()
            .load(url)
            .submit()
            .get()
    }
}
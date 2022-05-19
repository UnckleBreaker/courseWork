package com.example.data.mappers.character

import android.content.Context
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.data.api.models.character.ResponceCharacters
import com.example.data.mappers.ConvertToFile
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.character.*

@GlideModule
class CharactersDataToDomainMapper(val context: Context) : DataToDomainMapper<ResponceCharacters, ModelCharacterDomain>,AppGlideModule(){

    override fun map(from: ResponceCharacters): ModelCharacterDomain {
        return from.let { it ->
            ModelCharacterDomain(Info( next = it.info.next,
                pages = it.info.pages,),
                results =it.results.map { ResultCharcterDomain(it.created,it.episode,it.gender,
                    it.id,
                    ConvertToFile.toFile(context, it.image),Location(it.location.name,it.location.url),it.name,
                    Origin(it.origin.name,it.origin.url),it.species,it.status,it.type,it.url) })
        }
    }
}
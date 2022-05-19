package com.example.data.mappers.character

import android.content.Context
import com.example.data.db.entity.character.EntityCharacter
import com.example.data.db.entity.character.Location
import com.example.data.db.entity.character.Origin
import com.example.data.mappers.DataToDomainMapper

import com.example.domain.model.character.ResultCharcterDomain

class CharactersDataToEntityMapper(val context: Context) : DataToDomainMapper<ResultCharcterDomain,EntityCharacter> {
    override fun map(it: ResultCharcterDomain): EntityCharacter {
        return EntityCharacter(it.created,it.episode,it.gender,
            it.id, it.image,
            Location(it.location.name,it.location.url),it.name,
            Origin(it.origin.name,it.origin.url),it.species,it.status,it.type,it.url) }
    }

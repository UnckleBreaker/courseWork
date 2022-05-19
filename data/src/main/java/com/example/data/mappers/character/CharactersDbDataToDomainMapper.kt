package com.example.data.mappers.character

import android.content.Context
import com.example.data.db.entity.character.EntityCharacter
import com.example.domain.model.character.Location
import com.example.domain.model.character.Origin
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.character.*

class CharactersDbDataToDomainMapper(val context: Context) : DataToDomainMapper<List<EntityCharacter>,ModelCharacterDomain> {
    override fun map(it: List<EntityCharacter>): ModelCharacterDomain {
        return ModelCharacterDomain(info =  null, results = it.map {
            ResultCharcterDomain(it.created,it.episode,it.gender,it.id,it.image,
                Location(it.name,it.url),it.name,Origin(it.name,it.url),it.species,it.status,it.type,it.url)
        })
    }
}
package com.example.coursework.mappers

import com.example.app.mappers.DomainToAppMapper
import com.example.coursework.model.character.Location
import com.example.coursework.model.character.Origin
import com.example.coursework.model.character.ResultCharacter
import com.example.domain.model.character.ResultCharcterDomain

object OneCharacterDomainToAppMapper :
    DomainToAppMapper<List<ResultCharcterDomain>, List<ResultCharacter>> {
    override fun map(from: List<ResultCharcterDomain>): List<ResultCharacter> {
        var list = mutableListOf<ResultCharacter>()
        from.forEach {
            list.add(
                ResultCharacter(
                    it.created, it.episode, it.gender,
                    it.id, it.image, Location(it.location.name, it.location.url),
                    it.name, Origin(it.origin.name, it.origin.url), it.species, it.status, it.url
                )
            )
        }
        return list
    }
}
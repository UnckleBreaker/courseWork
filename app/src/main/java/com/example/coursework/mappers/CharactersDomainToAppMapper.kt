package com.example.app.mappers


import com.example.coursework.model.character.*
import com.example.domain.model.character.ModelCharacterDomain

object CharactersDomainToAppMapper : DomainToAppMapper<ModelCharacterDomain, ModelCharacterApp> {

    override fun map(from: ModelCharacterDomain): ModelCharacterApp {
        return from.let {
            ModelCharacterApp(Info(it.info?.next), results = it.results.map {
                ResultCharacter(
                    it.created,
                    it.episode,
                    it.gender,
                    it.id,
                    it.image,
                    Location(it.location.name, it.location.url),
                    it.name,
                    Origin(it.origin.name, it.origin.url),
                    it.species,
                    it.status,
                    it.url
                )
            })
        }
    }
}
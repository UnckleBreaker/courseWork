package com.example.data.mappers.character

import android.content.Context
import com.example.data.api.models.character.Result
import com.example.data.mappers.ConvertToFile
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.character.Location
import com.example.domain.model.character.Origin
import com.example.domain.model.character.ResultCharcterDomain

class OneCharacterDatatoDomainMapper(val context: Context) :
    DataToDomainMapper<List<Result>, List<ResultCharcterDomain>> {

    override fun map(from: List<Result>): List<ResultCharcterDomain> {
        var list = mutableListOf<ResultCharcterDomain>()
        from.forEach {
            list.add(ResultCharcterDomain( it.created, it.episode, it.gender,
                it.id, ConvertToFile.toFile(context, it.image), Location(it.location.name, it.location.url),
                it.name, Origin(it.origin.name, it.origin.url), it.species, it.status,it.type,it.url))
        }
        return list
    }
}
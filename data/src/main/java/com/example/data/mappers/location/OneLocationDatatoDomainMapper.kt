package com.example.data.mappers.location

import com.example.data.api.models.location.Result
import com.example.data.mappers.DataToDomainMapper
import com.example.domain.model.locations.ResultLocationsDomain

object OneLocationDatatoDomainMapper : DataToDomainMapper<Result, ResultLocationsDomain> {
    override fun map(from: Result): ResultLocationsDomain {
      return  from.let {
          ResultLocationsDomain(it.created,it.dimension,it.id,it.name,it.residents,it.type,it.url)
      }
    }
}
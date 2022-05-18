package com.example.domain.usecases.byDb.find

import com.example.domain.repositories.ApiRepository
import com.example.domain.repositories.DbRepository

class FindEpisodesByDbUseCase (val repository: DbRepository) {

    fun execute(search:String) = repository.findEpisodesDb(search)
}
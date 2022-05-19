package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.EpisodeViewModel


import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.filter.FilterEpisodesByApiUseCase
import com.example.domain.usecases.byApi.find.FindEpisodesByApiUseCase
import com.example.domain.usecases.byApi.get.GetEpisodesByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterEpisodesByDbiUseCase
import com.example.domain.usecases.byDb.find.FindEpisodesByDbUseCase
import com.example.domain.usecases.byDb.get.GetEpisodesByDbUseCase

class EpisodesViewModelFactory(val getEpisodesUseCase:GetEpisodesByApiUseCase,val findEpisodesByApiUseCase:FindEpisodesByApiUseCase,
                               val getEpisodesByDbUseCase:GetEpisodesByDbUseCase,
                               val findEpisodesByADbUseCase:FindEpisodesByDbUseCase,
                               val filterEpisodesByApiUseCase:FilterEpisodesByApiUseCase,
                               val filterEpisodesByDbiUseCase:FilterEpisodesByDbiUseCase

) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeViewModel(getEpisodesUseCase = getEpisodesUseCase,
        findEpisodesByApiUseCase =findEpisodesByApiUseCase,
         getEpisodesByDbUseCase = getEpisodesByDbUseCase,
        findEpisodesByDbUseCase = findEpisodesByADbUseCase,
        filterEpisodesByApiUseCase = filterEpisodesByApiUseCase,
        filterEpisodesByDbiUseCase =filterEpisodesByDbiUseCase ) as T

    }
}
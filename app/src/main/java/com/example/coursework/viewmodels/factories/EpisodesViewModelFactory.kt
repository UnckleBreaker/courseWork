package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.EpisodeViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.db.EpisodesRequestDb

import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.find.FindEpisodesByApiUseCase
import com.example.domain.usecases.byApi.get.GetEpisodesByApiUseCase
import com.example.domain.usecases.byDb.find.FindEpisodesByDbUseCase
import com.example.domain.usecases.byDb.get.GetEpisodesByDbUseCase

class EpisodesViewModelFactory(context: Context) :ViewModelProvider.Factory {


    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,null,EpisodesRequest(), null,null,null,EpisodesRequestDb(context))
    }
    val getEpisodesUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetEpisodesByApiUseCase(repository) }
    val findEpisodesByApiUseCase by lazy(LazyThreadSafetyMode.NONE) { FindEpisodesByApiUseCase(repository)  }
    val getEpisodesByDbUseCase by lazy(LazyThreadSafetyMode.NONE) { GetEpisodesByDbUseCase(repository)  }
    val findEpisodesByADbUseCase by lazy(LazyThreadSafetyMode.NONE) { FindEpisodesByDbUseCase(repository)  }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeViewModel(getEpisodesUseCase = getEpisodesUseCase,
        findEpisodesByApiUseCase =findEpisodesByApiUseCase,
         getEpisodesByDbUseCase = getEpisodesByDbUseCase,
        findEpisodesByDbUseCase = findEpisodesByADbUseCase) as T

    }
}
package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.EpisodeViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest

import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.GetEpisodesByApiUseCase

class EpisodesViewModelFactory(context: Context) :ViewModelProvider.Factory {


    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,CharactersRequest(),EpisodesRequest())
    }
    val getEpisodesUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetEpisodesByApiUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodeViewModel(getEpisodesUseCase = getEpisodesUseCase) as T

    }
}
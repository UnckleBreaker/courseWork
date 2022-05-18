package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsCharactersViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.db.EpisodesRequestDb
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeEpisodesByApiUseCase

class DetailsCharacterViewModelFactory(context: Context) : ViewModelProvider.Factory {
    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context, CharactersRequest(),EpisodesRequest(),null,null,null,EpisodesRequestDb(context))
    }
    val getSomeEpisodesByApiUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetSomeEpisodesByApiUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsCharactersViewModel(getSomeEpisodesByApiUseCase = getSomeEpisodesByApiUseCase) as T

    }

}
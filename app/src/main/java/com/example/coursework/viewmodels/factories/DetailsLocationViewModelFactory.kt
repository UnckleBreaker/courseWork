package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsLocationsViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetSomeLocationsByApiUseCase

class DetailsLocationViewModelFactory(context: Context) : ViewModelProvider.Factory {
    val repository by lazy(LazyThreadSafetyMode.NONE) {
        RepositoryImpl(context, CharactersRequest(),null, LocationsRequest(),null,null,null)
    }
    val getSomeCharactersByApiUseCase by lazy { GetSomeCharactersByApiUseCase(repository) }
    val getSomeLocationsByApiUseCase by lazy { GetSomeLocationsByApiUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  DetailsLocationsViewModel(getSomeCharactersByApiUseCase,getSomeLocationsByApiUseCase) as T
    }
}
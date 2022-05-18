package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsEpisodesViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase

class DetailsEpisodesViewModelFactory (context: Context) : ViewModelProvider.Factory {

    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,CharactersRequest(), EpisodesRequest(), null,null,null,null)
    }

    val getSomeCharactersByApiUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetSomeCharactersByApiUseCase(repository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsEpisodesViewModel(getSomeCharactersByApiUseCase) as T
    }
}
package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.CharactersViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.GetCharacktersByApiUseCase

class CharactersViewModelFactory(context: Context) :ViewModelProvider.Factory {


    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,CharactersRequest(),EpisodesRequest())
    }
    val getCharacktersUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetCharacktersByApiUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(getCharacktersUseCase = getCharacktersUseCase) as T

    }
}
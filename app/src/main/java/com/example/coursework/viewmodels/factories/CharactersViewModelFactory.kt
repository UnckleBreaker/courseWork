package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.CharactersViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.db.CharactersRequestDb
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.filter.FilterCharactersByApiUseCase
import com.example.domain.usecases.byApi.find.FindCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetCharacktersByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterCharactersByDbUseCase
import com.example.domain.usecases.byDb.find.FindCharactersByDbUseCase
import com.example.domain.usecases.byDb.get.GetCharacktersByDbUseCase

class CharactersViewModelFactory(context: Context) :ViewModelProvider.Factory {


    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,CharactersRequest(),null,null, CharactersRequestDb(context),null,null)
    }
    val getCharacktersUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetCharacktersByApiUseCase(repository) }
    val findCharactersByApiUseCase  by lazy(LazyThreadSafetyMode.NONE){ FindCharactersByApiUseCase(repository) }
    val getCharacktersByUseCase by lazy(LazyThreadSafetyMode.NONE){GetCharacktersByDbUseCase(repository)}
    val findCharactersByBdUseCase by lazy(LazyThreadSafetyMode.NONE){FindCharactersByDbUseCase(repository)}
    val filterCharactersByApiUseCase by lazy(LazyThreadSafetyMode.NONE){FilterCharactersByApiUseCase(repository)}
    val filterCharactersByADbUseCase by lazy(LazyThreadSafetyMode.NONE){FilterCharactersByDbUseCase(repository)}
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(getCharacktersUseCase = getCharacktersUseCase,
        findCharactersByApiUseCase = findCharactersByApiUseCase,getCharacktersByUseCase,
        findCharactersByDbUseCase = findCharactersByBdUseCase,
        filterCharactersByADbUseCase = filterCharactersByADbUseCase,
        filterCharactersByApiUseCase = filterCharactersByApiUseCase) as T

    }
}
package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.CharactersViewModel

import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.filter.FilterCharactersByApiUseCase
import com.example.domain.usecases.byApi.find.FindCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetCharacktersByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterCharactersByDbUseCase
import com.example.domain.usecases.byDb.find.FindCharactersByDbUseCase
import com.example.domain.usecases.byDb.get.GetCharacktersByDbUseCase

class CharactersViewModelFactory(
    val getCharacktersUseCase: GetCharacktersByApiUseCase,
    val findCharactersByApiUseCase: FindCharactersByApiUseCase,
    val getCharacktersByUseCase: GetCharacktersByDbUseCase,
    val findCharactersByBdUseCase: FindCharactersByDbUseCase,
    val filterCharactersByApiUseCase: FilterCharactersByApiUseCase,
    val filterCharactersByADbUseCase: FilterCharactersByDbUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(
            getCharacktersUseCase = getCharacktersUseCase,
            findCharactersByApiUseCase = findCharactersByApiUseCase, getCharacktersByUseCase,
            findCharactersByDbUseCase = findCharactersByBdUseCase,
            filterCharactersByADbUseCase = filterCharactersByADbUseCase,
            filterCharactersByApiUseCase = filterCharactersByApiUseCase
        ) as T

    }
}
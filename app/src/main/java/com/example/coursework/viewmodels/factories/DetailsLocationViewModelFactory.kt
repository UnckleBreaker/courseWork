package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsLocationsViewModel
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetSomeLocationsByApiUseCase

class DetailsLocationViewModelFactory(
    val getSomeCharactersByApiUseCase: GetSomeCharactersByApiUseCase,
    val getSomeLocationsByApiUseCase: GetSomeLocationsByApiUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsLocationsViewModel(
            getSomeCharactersByApiUseCase,
            getSomeLocationsByApiUseCase
        ) as T
    }
}
package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsEpisodesViewModel
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase

class DetailsEpisodesViewModelFactory (val getSomeCharactersByApiUseCase:GetSomeCharactersByApiUseCase) : ViewModelProvider.Factory {

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsEpisodesViewModel(getSomeCharactersByApiUseCase) as T
    }
}
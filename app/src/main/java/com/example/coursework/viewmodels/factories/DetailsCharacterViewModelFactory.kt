package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.DetailsCharactersViewModel
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.get.GetSomeEpisodesByApiUseCase

class DetailsCharacterViewModelFactory(val getSomeEpisodesByApiUseCase: GetSomeEpisodesByApiUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsCharactersViewModel(getSomeEpisodesByApiUseCase = getSomeEpisodesByApiUseCase) as T

    }

}
package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.LocationsViewModel
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.filter.FilterLocationsByApiUseCase
import com.example.domain.usecases.byApi.find.FindLocationsByApiUseCase
import com.example.domain.usecases.byApi.get.GetLocationsByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterLocationsByDbiUseCase
import com.example.domain.usecases.byDb.find.FindLocationsByDbUseCase
import com.example.domain.usecases.byDb.get.GetLocationsByDbUseCase

class LocationsViewModelFactory(
    val GetLocationsByApiUseCase: GetLocationsByApiUseCase,
    val findLocationsByApiUseCase: FindLocationsByApiUseCase,
    val getLocationsByDbUseCase: GetLocationsByDbUseCase,
    val findLocationsByDbUseCase: FindLocationsByDbUseCase,
    val filterLocationsByApiUseCase: FilterLocationsByApiUseCase,
    val filterLocationsByDbiUseCase: FilterLocationsByDbiUseCase

) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationsViewModel(
            locationsUseCase = GetLocationsByApiUseCase,
            findLocationsByApiUseCase = findLocationsByApiUseCase, getLocationsByDbUseCase,
            findLocationsByBdUseCase = findLocationsByDbUseCase,
            filterLocationsByApiUseCase = filterLocationsByApiUseCase,
            filterLocationsByDbiUseCase = filterLocationsByDbiUseCase
        ) as T

    }
}
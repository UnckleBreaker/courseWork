package com.example.coursework.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coursework.viewmodels.LocationsViewModel
import com.example.data.api.CharactersRequest
import com.example.data.api.EpisodesRequest
import com.example.data.api.LocationsRequest
import com.example.data.db.LocationsRequestDb
import com.example.data.repository.RepositoryImpl
import com.example.domain.usecases.byApi.filter.FilterLocationsByApiUseCase
import com.example.domain.usecases.byApi.find.FindLocationsByApiUseCase
import com.example.domain.usecases.byApi.get.GetLocationsByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterLocationsByDbiUseCase
import com.example.domain.usecases.byDb.find.FindLocationsByDbUseCase
import com.example.domain.usecases.byDb.get.GetLocationsByDbUseCase

class LocationsViewModelFactory(context: Context) :ViewModelProvider.Factory {


    val repository by lazy(LazyThreadSafetyMode.NONE){
        RepositoryImpl(context,null,null,LocationsRequest(),null,LocationsRequestDb(context),null)
    }
    val GetLocationsByApiUseCase  by lazy(LazyThreadSafetyMode.NONE){ GetLocationsByApiUseCase(repository) }
    val findLocationsByApiUseCase by lazy(LazyThreadSafetyMode.NONE){ FindLocationsByApiUseCase(repository) }
    val getLocationsByDbUseCase by lazy(LazyThreadSafetyMode.NONE){ GetLocationsByDbUseCase(repository) }
    val findLocationsByDbUseCase by lazy(LazyThreadSafetyMode.NONE){ FindLocationsByDbUseCase(repository) }
    val filterLocationsByApiUseCase by lazy(LazyThreadSafetyMode.NONE){ FilterLocationsByApiUseCase(repository) }
    val filterLocationsByDbiUseCase by lazy(LazyThreadSafetyMode.NONE){ FilterLocationsByDbiUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationsViewModel(locationsUseCase = GetLocationsByApiUseCase,
        findLocationsByApiUseCase = findLocationsByApiUseCase,getLocationsByDbUseCase,
        findLocationsByBdUseCase =findLocationsByDbUseCase,
        filterLocationsByApiUseCase = filterLocationsByApiUseCase,
        filterLocationsByDbiUseCase = filterLocationsByDbiUseCase) as T

    }
}
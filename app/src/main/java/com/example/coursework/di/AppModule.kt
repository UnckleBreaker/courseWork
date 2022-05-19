package com.example.coursework.di

import android.content.Context
import com.example.coursework.viewmodels.factories.*
import com.example.domain.usecases.byApi.filter.FilterCharactersByApiUseCase
import com.example.domain.usecases.byApi.filter.FilterEpisodesByApiUseCase
import com.example.domain.usecases.byApi.filter.FilterLocationsByApiUseCase
import com.example.domain.usecases.byApi.find.FindCharactersByApiUseCase
import com.example.domain.usecases.byApi.find.FindEpisodesByApiUseCase
import com.example.domain.usecases.byApi.find.FindLocationsByApiUseCase
import com.example.domain.usecases.byApi.get.*
import com.example.domain.usecases.byDb.filter.FilterCharactersByDbUseCase
import com.example.domain.usecases.byDb.filter.FilterEpisodesByDbiUseCase
import com.example.domain.usecases.byDb.filter.FilterLocationsByDbiUseCase
import com.example.domain.usecases.byDb.find.FindCharactersByDbUseCase
import com.example.domain.usecases.byDb.find.FindEpisodesByDbUseCase
import com.example.domain.usecases.byDb.find.FindLocationsByDbUseCase
import com.example.domain.usecases.byDb.get.GetCharacktersByDbUseCase
import com.example.domain.usecases.byDb.get.GetEpisodesByDbUseCase
import com.example.domain.usecases.byDb.get.GetLocationsByDbUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() :Context{
        return context
    }

    @Singleton
    @Provides
    fun provideCharactersViewModelFactory(
        getCharacktersUseCase: GetCharacktersByApiUseCase,
        findCharactersByApiUseCase: FindCharactersByApiUseCase,
        getCharacktersByUseCase: GetCharacktersByDbUseCase,
        findCharactersByBdUseCase: FindCharactersByDbUseCase,
        filterCharactersByApiUseCase: FilterCharactersByApiUseCase,
        filterCharactersByADbUseCase: FilterCharactersByDbUseCase
    ): CharactersViewModelFactory {
        return CharactersViewModelFactory(
            getCharacktersUseCase,
            findCharactersByApiUseCase,
            getCharacktersByUseCase,
            findCharactersByBdUseCase,
            filterCharactersByApiUseCase,
            filterCharactersByADbUseCase
        )
    }

    @Singleton
    @Provides
    fun provideDetailsCharacterViewModelFactory(getSomeEpisodesByApiUseCase: GetSomeEpisodesByApiUseCase): DetailsCharacterViewModelFactory {
        return DetailsCharacterViewModelFactory(getSomeEpisodesByApiUseCase)
    }

    @Singleton
    @Provides
    fun provideDetailsEpisodesViewModelFactory(getSomeCharactersByApiUseCase: GetSomeCharactersByApiUseCase): DetailsEpisodesViewModelFactory {
        return DetailsEpisodesViewModelFactory(getSomeCharactersByApiUseCase)
    }

    @Singleton
    @Provides
    fun provideDetailsLocationViewModelFactory( getSomeCharactersByApiUseCase: GetSomeCharactersByApiUseCase,
                                                getSomeLocationsByApiUseCase: GetSomeLocationsByApiUseCase
    ): DetailsLocationViewModelFactory {
        return DetailsLocationViewModelFactory(getSomeCharactersByApiUseCase, getSomeLocationsByApiUseCase)
    }

    @Singleton
    @Provides
    fun provideEpisodesViewModelFactory( getEpisodesUseCase: GetEpisodesByApiUseCase, findEpisodesByApiUseCase: FindEpisodesByApiUseCase,
                                         getEpisodesByDbUseCase: GetEpisodesByDbUseCase,
                                         findEpisodesByADbUseCase: FindEpisodesByDbUseCase,
                                         filterEpisodesByApiUseCase: FilterEpisodesByApiUseCase,
                                         filterEpisodesByDbiUseCase: FilterEpisodesByDbiUseCase
    ): EpisodesViewModelFactory {
        return EpisodesViewModelFactory(getEpisodesUseCase, findEpisodesByApiUseCase, getEpisodesByDbUseCase, findEpisodesByADbUseCase, filterEpisodesByApiUseCase, filterEpisodesByDbiUseCase)
    }

    @Singleton
    @Provides
    fun provideLocationsViewModelFactory( getLocationsByApiUseCase: GetLocationsByApiUseCase,
                                          findLocationsByApiUseCase: FindLocationsByApiUseCase,
                                          getLocationsByDbUseCase: GetLocationsByDbUseCase,
                                          findLocationsByDbUseCase: FindLocationsByDbUseCase,
                                          filterLocationsByApiUseCase: FilterLocationsByApiUseCase,
                                          filterLocationsByDbiUseCase: FilterLocationsByDbiUseCase
    ): LocationsViewModelFactory {
        return LocationsViewModelFactory(getLocationsByApiUseCase,findLocationsByApiUseCase,getLocationsByDbUseCase,findLocationsByDbUseCase,filterLocationsByApiUseCase,filterLocationsByDbiUseCase)
    }



}
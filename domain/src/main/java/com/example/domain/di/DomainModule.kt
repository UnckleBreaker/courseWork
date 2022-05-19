package com.example.domain.di

import com.example.domain.repositories.ApiRepository
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
class DomainModule {



    @Singleton
    @Provides
    fun providesFilterCharactersByApiUseCase(apiRepository: ApiRepository): FilterCharactersByApiUseCase {
        return FilterCharactersByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFilterEpisodesByApiUseCase(apiRepository: ApiRepository): FilterEpisodesByApiUseCase {
        return FilterEpisodesByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFilterLocationsByApiUseCase(apiRepository: ApiRepository): FilterLocationsByApiUseCase {
        return FilterLocationsByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindCharactersByApiUseCase(apiRepository: ApiRepository): FindCharactersByApiUseCase {
        return FindCharactersByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindEpisodesByApiUseCase(apiRepository: ApiRepository): FindEpisodesByApiUseCase {
        return FindEpisodesByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindLocationsByApiUseCase(apiRepository: ApiRepository): FindLocationsByApiUseCase {
        return FindLocationsByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetCharactersByApiUseCase(apiRepository: ApiRepository): GetCharacktersByApiUseCase {
        return GetCharacktersByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetLocationsByApiUseCase(apiRepository: ApiRepository): GetLocationsByApiUseCase {
        return GetLocationsByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetEpisodesByApiUseCase(apiRepository: ApiRepository): GetEpisodesByApiUseCase {
        return GetEpisodesByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetSomeEpisodesByApiUseCase(apiRepository: ApiRepository): GetSomeEpisodesByApiUseCase {
        return GetSomeEpisodesByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetSomeCharactersByApiUseCase(apiRepository: ApiRepository): GetSomeCharactersByApiUseCase {
        return GetSomeCharactersByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetSomeLocationsByApiUseCase(apiRepository: ApiRepository): GetSomeLocationsByApiUseCase {
        return GetSomeLocationsByApiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFilterLocationsByADbUseCase(apiRepository: ApiRepository): FilterLocationsByDbiUseCase {
        return FilterLocationsByDbiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFilterEpisodesByADbUseCase(apiRepository: ApiRepository): FilterEpisodesByDbiUseCase {
        return FilterEpisodesByDbiUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFilterCharactersByADbUseCase(apiRepository: ApiRepository): FilterCharactersByDbUseCase {
        return FilterCharactersByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindCharactersByADbUseCase(apiRepository: ApiRepository): FindCharactersByDbUseCase {
        return FindCharactersByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindEpisodesByADbUseCase(apiRepository: ApiRepository): FindEpisodesByDbUseCase {
        return FindEpisodesByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesFindLocationsByADbUseCase(apiRepository: ApiRepository): FindLocationsByDbUseCase {
        return FindLocationsByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetLocationsByADbUseCase(apiRepository: ApiRepository): GetLocationsByDbUseCase {
        return GetLocationsByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetCharactersByADbUseCase(apiRepository: ApiRepository): GetCharacktersByDbUseCase {
        return GetCharacktersByDbUseCase(apiRepository)
    }

    @Singleton
    @Provides
    fun providesGetEpisodesByADbUseCase(apiRepository: ApiRepository): GetEpisodesByDbUseCase {
        return GetEpisodesByDbUseCase(apiRepository)
    }






































}
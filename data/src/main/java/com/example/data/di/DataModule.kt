package com.example.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.data.api.rep.*
import com.example.data.db.AppDataBase
import com.example.data.repository.RepositoryImpl
import com.example.domain.repositories.ApiRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideEpisodesRepository(
        context: Context,
        characterApi: CharacterApiService?,
        episodeApi: EpisodesApiService?,
        locationApi: LocationsApiService?,
        appDataBase: AppDataBase
    ): ApiRepository {
        return RepositoryImpl(context, characterApi, episodeApi, locationApi, appDataBase)
    }

//    @Singleton
//    @Provides
//    fun provideApiRepository(
//        context: Context, charactersRequest: CharactersRequest,
//        episodesRequest: EpisodesRequest, locationsRequest: LocationsRequest,appDataBase: AppDataBase
//    ): ApiRepository {
//        return RepositoryImpl(context = context, charactersRequest, episodesRequest, locationsRequest,appDataBase
//        )
//    }
//    @Singleton
//    @Provides
//    fun provideDbRepository(context: Context, charactersRequestDb: CharactersRequestDb,
//        episodesRequestDb: EpisodesRequestDb,
//        locationsRequestDb: LocationsRequestDb,
//        appDataBase: AppDataBase
//    ): ApiRepository {
//        return RepositoryImpl(context = context, null, null,
//            null, appDataBase)
//    }

//    @Singleton
//    @Provides
//    fun provideCharactersRequestDb(context: Context): CharactersRequestDb {
//        return CharactersRequestDb(context = context)
//    }

//    @Singleton
//    @Provides
//    fun provideEpisodesRequestDb(context: Context): EpisodesRequestDb {
//        return EpisodesRequestDb(context = context)
//    }

//    @Singleton
//    @Provides
//    fun provideLocationsRequestDb(context: Context): LocationsRequestDb {
//        return LocationsRequestDb(context = context)
//    }

//    @Singleton
//    @Provides
//    fun provideCharactersRequestApi(): CharactersRequest {
//        return CharactersRequest()
//    }
//
//    @Singleton
//    @Provides
//    fun provideEpisodesRequestApi(): EpisodesRequest {
//        return EpisodesRequest()
//    }



//    @Singleton
//    @Provides
//    fun provideLocationsRequestApi(): LocationsRequest {
//        return LocationsRequest()
//    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDataBase {
        return Room.databaseBuilder(
           context,
            AppDataBase::class.java,
            "rick_and_morty"
        ).build()
    }

//    @Provides
//    @Singleton
//    fun provideRetrofitBuilder(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Const.baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//    }

    @Singleton
    @Provides
    fun provideCharacterRepositoryApi(client: OkHttpClient): CharacterApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CharacterApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideEpisodeRepositoryApi(client: OkHttpClient): EpisodesApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(EpisodesApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideLocationsRepositoryApi(client: OkHttpClient): LocationsApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(LocationsApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS).addInterceptor(logging).build()
        }




}
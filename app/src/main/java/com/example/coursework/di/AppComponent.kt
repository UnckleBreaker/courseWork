package com.example.coursework.di

import com.example.coursework.baseFragments.EpisodesFragment
import com.example.coursework.baseFragments.LocationFragment
import com.example.coursework.baseFragments.СharactersFragment
import com.example.coursework.deatailsFragments.DetailsCharactersFragment
import com.example.coursework.deatailsFragments.DetailsEpisodesFragment
import com.example.coursework.deatailsFragments.DetailsLocationsFragment
import com.example.data.di.DataModule
import com.example.domain.di.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(fragment:EpisodesFragment)

    fun inject(fragment:LocationFragment)

    fun inject(fragment: СharactersFragment)

    fun inject(fragment: DetailsCharactersFragment)

    fun inject(fragment: DetailsEpisodesFragment)

    fun inject(fragment: DetailsLocationsFragment)
}
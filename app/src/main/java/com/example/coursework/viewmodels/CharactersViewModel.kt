package com.example.coursework.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.mappers.CharactersDomainToAppMapper
import com.example.coursework.model.character.ModelCharacterApp
import com.example.coursework.model.character.ResultCharacter
import com.example.domain.usecases.byApi.filter.FilterCharactersByApiUseCase
import com.example.domain.usecases.byApi.find.FindCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetCharacktersByApiUseCase
import com.example.domain.usecases.byDb.filter.FilterCharactersByDbUseCase
import com.example.domain.usecases.byDb.find.FindCharactersByDbUseCase
import com.example.domain.usecases.byDb.get.GetCharacktersByDbUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersViewModel(
    val getCharacktersUseCase : GetCharacktersByApiUseCase,
    val findCharactersByApiUseCase: FindCharactersByApiUseCase,
    val getCharactersByDbuseCase: GetCharacktersByDbUseCase,
    val findCharactersByDbUseCase: FindCharactersByDbUseCase,
    val filterCharactersByApiUseCase: FilterCharactersByApiUseCase,
    val filterCharactersByADbUseCase: FilterCharactersByDbUseCase
): ViewModel() {

    var data = MutableLiveData<ModelCharacterApp>()
    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData(true)
    val cdisposable =CompositeDisposable()

    fun get(isConnected: Boolean) {
        if(isConnected){
                val disposable =getCharacktersUseCase.execute()
                    .map { CharactersDomainToAppMapper.map(it) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ handleData(it) }, { handleError(it) })
                cdisposable.add(disposable)
        }
        else{
            val disposable =getCharactersByDbuseCase.execute()
                .map { CharactersDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })

            cdisposable.add(disposable)
        }
    }

    private fun handleError(it: Throwable) {
        Log.d("CharactersViewModel", "handleError: $it")
        error.postValue(it.message)
    }

    private fun handleData(it: ModelCharacterApp) {
        Log.d("CharactersViewModel", "handleData: $it")
        data.postValue(it)
        isLoading.postValue(false)
    }

    fun findData(newText: String, isConnected: Boolean) {
        if(isConnected){
            isLoading.postValue(true)
            val disposable =findCharactersByApiUseCase.execute(newText)
                .map { CharactersDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }else{
            isLoading.postValue(true)
            val disposable =findCharactersByDbUseCase.execute(newText)
                .map { CharactersDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }

    }
    fun filterData(
        status: String,
        spicies: String,
        gender: String,
        type: String,
        isConnected: Boolean
    ) {
        if(isConnected){
            isLoading.postValue(true)
            val disposable =filterCharactersByApiUseCase.execute(status,spicies,gender,type)
                .map { CharactersDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }else{
            isLoading.postValue(true)
            val disposable =filterCharactersByADbUseCase.execute(status,spicies,gender,type)
                .map { CharactersDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }
    }

    override fun onCleared() {
        super.onCleared()
        cdisposable.clear()
    }
}

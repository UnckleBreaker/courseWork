package com.example.coursework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.mappers.CharactersDomainToAppMapper
import com.example.coursework.model.character.ModelCharacterApp
import com.example.data.models.episode.ResponceEpisode
import com.example.domain.model.character.ModelCharacterDomain
import com.example.domain.usecases.byApi.GetCharacktersByApiUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CharactersViewModel(val getCharacktersUseCase : GetCharacktersByApiUseCase) : ViewModel() {

    var data = MutableLiveData<ModelCharacterApp>()

    fun get() {
        getCharacktersUseCase.execute()
            .map { CharactersDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ModelCharacterApp>() {
                override fun onNext(t: ModelCharacterApp) {
                    data.postValue(t)
                }

                override fun onError(e: Throwable) {
                    Log.d("CharactersViewModel", "onError: ${e.message} ")
                }

                override fun onComplete() {
                    Log.d("CharactersViewModel", "onComplite ")
                }
            })
    }
}
package com.example.coursework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.EpisodesDomainToAppMapper
import com.example.coursework.model.episode.ModelEpisodeApp
import com.example.domain.usecases.byApi.GetEpisodesByApiUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class EpisodeViewModel(val getEpisodesUseCase: GetEpisodesByApiUseCase) : ViewModel() {

    val data =MutableLiveData<ModelEpisodeApp>()

    fun get(){
        getEpisodesUseCase.execute()
            .map { EpisodesDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ModelEpisodeApp>() {
                override fun onNext(t: ModelEpisodeApp) {
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
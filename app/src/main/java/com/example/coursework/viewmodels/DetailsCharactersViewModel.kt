package com.example.coursework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.ConvertId
import com.example.coursework.mappers.OneEpisodesDomainToAppMapper
import com.example.coursework.model.episode.ResultEpisode
import com.example.domain.usecases.byApi.get.GetSomeEpisodesByApiUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsCharactersViewModel(val getSomeEpisodesByApiUseCase: GetSomeEpisodesByApiUseCase) :
    ViewModel() {

    var data = MutableLiveData<List<ResultEpisode>>()
    var isLoading = MutableLiveData(true)

    fun loadEpisodes(ids: List<String>) {
        getSomeEpisodesByApiUseCase.execute(ConvertId.makeIds(ids))
            .map { OneEpisodesDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleData(it) }, { handleError(it) })


    }

    private fun handleError(it: Throwable) {
        Log.d("DetailsCharactersViewModel", "handleError: ${it.message}")
    }

    private fun handleData(it: List<ResultEpisode>) {
        data.postValue(it)
        isLoading.postValue(false)
    }


}
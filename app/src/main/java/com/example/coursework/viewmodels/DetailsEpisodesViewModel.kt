package com.example.coursework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.ConvertId
import com.example.coursework.mappers.OneCharacterDomainToAppMapper
import com.example.coursework.model.character.ResultCharacter
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsEpisodesViewModel(val getSomeCharactersByApiUseCase: GetSomeCharactersByApiUseCase) :
    ViewModel() {

    var data = MutableLiveData<List<ResultCharacter>>()
    val isLoading = MutableLiveData(true)

    fun loadEpisodes(ids: List<String>) {
        getSomeCharactersByApiUseCase.execute(ConvertId.makeIds(ids))
            .map { OneCharacterDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleData(it) }, { handleError(it) })
    }

    private fun handleError(it: Throwable) {
        Log.d("DetailsEpisodesViewModel", "handleError: ${it.message}")
    }

    private fun handleData(it: List<ResultCharacter>) {
        data.postValue(it)
        isLoading.postValue(false)
    }


}
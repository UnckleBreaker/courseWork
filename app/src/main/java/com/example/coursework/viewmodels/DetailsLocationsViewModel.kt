package com.example.coursework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.ConvertId
import com.example.coursework.mappers.OneCharacterDomainToAppMapper
import com.example.coursework.mappers.OneLocationDomainToAppMapper
import com.example.coursework.model.character.ResultCharacter
import com.example.coursework.model.location.ResultLocation
import com.example.domain.usecases.byApi.get.GetSomeCharactersByApiUseCase
import com.example.domain.usecases.byApi.get.GetSomeLocationsByApiUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsLocationsViewModel(
    val getSomeCharactersByApiUseCase: GetSomeCharactersByApiUseCase,
    val getSomeLocationsByApiUseCase: GetSomeLocationsByApiUseCase
) : ViewModel() {

    val dataList = MutableLiveData<List<ResultCharacter>>()
    val data = MutableLiveData<ResultLocation>()
    var isLoading = MutableLiveData(true)

    fun loadCharacters(residents: List<String>) {
        load(residents)
    }

    fun load(residents: List<String>) {
        getSomeCharactersByApiUseCase.execute(ConvertId.makeIds(residents))
            .map { OneCharacterDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleCharactersData(it) }, { handleCharactersError(it) })
    }

    private fun handleCharactersError(it: Throwable) {
        Log.d("DetailsEpisodesViewModel", "handleError: ${it.message}")
    }

    private fun handleCharactersData(it: List<ResultCharacter>) {
        dataList.postValue(it)
        isLoading.postValue(false)
    }

    fun loadLocation(url: String) {
        getSomeLocationsByApiUseCase.execute(ConvertId.makeId(url))
            .map { OneLocationDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleData(it) }, { handleError(it) })
    }

    private fun handleError(it: Throwable) {
        Log.d("DetailsLocationsViewModel", "onError: ${it.message} ")
    }

    private fun handleData(it: ResultLocation) {
        data.postValue(it)
        isLoading.postValue(false)
        load(it.residents)
    }
}
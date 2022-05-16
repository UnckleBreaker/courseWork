package com.example.coursework.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.EpisodesDomainToAppMapper
import com.example.coursework.model.episode.ModelEpisodeApp
import com.example.domain.usecases.byApi.find.FindEpisodesByApiUseCase
import com.example.domain.usecases.byApi.get.GetEpisodesByApiUseCase
import com.example.domain.usecases.byDb.get.GetEpisodesByDbUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EpisodeViewModel(
    val getEpisodesUseCase: GetEpisodesByApiUseCase,
    val findEpisodesByApiUseCase: FindEpisodesByApiUseCase,
    val getEpisodesByDbUseCase: GetEpisodesByDbUseCase
) : ViewModel() {

    val data = MutableLiveData<ModelEpisodeApp>()
    val isLoading = MutableLiveData<Boolean>(true)
    val cdisposable = CompositeDisposable()
    var error = MutableLiveData<String>()

    fun get(context: Context) {
        if(isConnected(context)){
            val disposable=  getEpisodesUseCase.execute()
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }else{
            val disposable=  getEpisodesByDbUseCase.execute()
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }
    }

    private fun handleError(it: Throwable) {
        error.postValue(it.message)
    }

    private fun handleData(it: ModelEpisodeApp) {
        data.postValue(it)
        isLoading.postValue(false)
    }

    fun filterData(newText: String) {
        isLoading.postValue(true)
        val disposable= findEpisodesByApiUseCase.execute(newText)
            .map { EpisodesDomainToAppMapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleData(it) }, { handleError(it) })
        cdisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        cdisposable.clear()
    }

    private fun isConnected(context: Context): Boolean {
        val connectivityManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }
}
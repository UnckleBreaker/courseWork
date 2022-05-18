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
import com.example.domain.usecases.byDb.find.FindEpisodesByDbUseCase
import com.example.domain.usecases.byDb.get.GetEpisodesByDbUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EpisodeViewModel(
    val getEpisodesUseCase: GetEpisodesByApiUseCase,
    val findEpisodesByApiUseCase: FindEpisodesByApiUseCase,
    val getEpisodesByDbUseCase: GetEpisodesByDbUseCase,
    val findEpisodesByDbUseCase: FindEpisodesByDbUseCase
) : ViewModel() {

    val data = MutableLiveData<ModelEpisodeApp>()
    val isLoading = MutableLiveData<Boolean>(true)
    val cdisposable = CompositeDisposable()
    var error = MutableLiveData<String>()

    fun get(context: Context) {
        if(isConnected(context)){
            Log.d("EpisodeViewModel", "get: by api get ")
            val disposable=  getEpisodesUseCase.execute()
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it)
                    Log.d("EpisodeViewModel", "get: $it")}, { handleError(it,"api")
                    Log.d("EpisodeViewModel", "error: $it")})
            cdisposable.add(disposable)
        }else{
            Log.d("EpisodeViewModel", "get: by bd ")
            val disposable=  getEpisodesByDbUseCase.execute()
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it,"bd") })
            cdisposable.add(disposable)
        }
    }

    private fun handleError(it: Throwable,str:String) {
        error.postValue(it.message + str)
    }

    private fun handleData(it: ModelEpisodeApp) {
        data.postValue(it)
        isLoading.postValue(false)
    }

    fun filterData(newText: String,context: Context) {
        if(isConnected(context)){
            Log.d("EpisodeViewModel", "get: by api filter ")
            isLoading.postValue(true)
            val disposable= findEpisodesByApiUseCase.execute(newText)
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it,"filer api") })
            cdisposable.add(disposable)
        }else{
            Log.d("EpisodeViewModel", "get: by bd ")
            isLoading.postValue(true)
            val disposable= findEpisodesByDbUseCase.execute(newText)
                .map { EpisodesDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it,"filer bd") })
            cdisposable.add(disposable)
        }

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
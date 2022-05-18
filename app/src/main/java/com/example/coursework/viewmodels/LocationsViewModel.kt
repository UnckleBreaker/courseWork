package com.example.coursework.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursework.mappers.LocationsDomainToAppMapper
import com.example.coursework.model.location.ModelLocationsApp
import com.example.domain.usecases.byApi.find.FindLocationsByApiUseCase
import com.example.domain.usecases.byApi.get.GetLocationsByApiUseCase
import com.example.domain.usecases.byDb.find.FindLocationsByDbUseCase
import com.example.domain.usecases.byDb.get.GetLocationsByDbUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LocationsViewModel(
    val locationsUseCase: GetLocationsByApiUseCase,
    val findLocationsByApiUseCase: FindLocationsByApiUseCase,
    val getLocationsByDbUseCase: GetLocationsByDbUseCase,
    val findLocationsByBdUseCase: FindLocationsByDbUseCase
) : ViewModel() {

    val data = MutableLiveData<ModelLocationsApp>()
    val isLoading = MutableLiveData(true)
    val cdisposable =CompositeDisposable()
    var error = MutableLiveData<String>()

    fun get(context: Context) {
        if (isConnected(context)){
            val disposable = locationsUseCase.execute()
                .map { LocationsDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }else{
            val disposable = getLocationsByDbUseCase.execute()
                .map { LocationsDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }
    }

    private fun handleError(it: Throwable) {
        error.postValue(it.message)
    }

    private fun handleData(it: ModelLocationsApp) {
        data.postValue(it)
        isLoading.postValue(false)
    }

    fun filterData(newText: String,context: Context) {

        if(isConnected(context)){
            isLoading.postValue(true)
            val disposable = findLocationsByApiUseCase.execute(newText)
                .map { LocationsDomainToAppMapper.map(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleData(it) }, { handleError(it) })
            cdisposable.add(disposable)
        }else{
            isLoading.postValue(true)
            val disposable = findLocationsByBdUseCase.execute(newText)
                .map { LocationsDomainToAppMapper.map(it) }
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

    private fun isConnected(context: Context): Boolean {
        val connectivityManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }
}
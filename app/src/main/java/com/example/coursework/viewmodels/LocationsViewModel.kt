package com.example.coursework.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.byApi.GetLocationsByApiUseCase

class LocationsViewModel(val locationsUseCase: GetLocationsByApiUseCase) :ViewModel() {

}
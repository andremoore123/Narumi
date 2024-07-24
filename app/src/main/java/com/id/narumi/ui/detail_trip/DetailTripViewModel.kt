package com.id.narumi.ui.detail_trip

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailTripViewModel(
    private val tripRepository: ITripRepository
): ViewModel() {
    private val _tripData = MutableLiveData<TripModel>()
    val tripData = _tripData

    fun fetchTripById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = tripRepository.fetchTripById(id)
            response?.let {
                _tripData.postValue(it)
            }
        }
    }
}
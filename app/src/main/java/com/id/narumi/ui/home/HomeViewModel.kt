package com.id.narumi.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.auth.UserModel
import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripModel
import com.id.narumi.utils.TripCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val tripRepository: ITripRepository,
    private val authRepository: IAuthRepository
) : ViewModel() {
    private val _popularList = MutableLiveData<List<TripModel>>()
    val popularList = _popularList

    private val _allTrips = MutableLiveData<List<TripModel>>()
    val allTrips = _allTrips

    private val _recommendedList = MutableLiveData<List<TripModel>>()
    val recommendedList = _recommendedList

    private val _userData = MutableLiveData<UserModel>()
    val userData = _userData

    fun fetchAllData() {
        fetchTrips()
        fetchRecommendedList()
        fetchProfileData()
        fetchPopularList()
    }

    private fun fetchRecommendedList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = tripRepository.fetchTripByCategory(TripCategories.Recommended.value)
            _recommendedList.postValue(response)
        }
    }

    private fun fetchTrips() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = tripRepository.fetchTrips()
            _allTrips.postValue(response)
        }
    }

    private fun fetchPopularList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = tripRepository.fetchTripByCategory(TripCategories.Popular.value)
            _popularList.postValue(response)
        }
    }

    private fun fetchProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authRepository.getCurrentUser()
            _userData.postValue(response)
        }
    }
}
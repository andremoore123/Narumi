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

    private val _userData = MutableLiveData<UserModel>()
    val userData = _userData

    fun fetchPopularList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = tripRepository.fetchTripByCategory(TripCategories.Popular.value)
            _popularList.postValue(response)
        }
    }

    fun fetchProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authRepository.getCurrentUser()
            _userData.postValue(response)
        }
    }
}
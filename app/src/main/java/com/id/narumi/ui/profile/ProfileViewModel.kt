package com.id.narumi.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.auth.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val authRepository: IAuthRepository,
) : ViewModel() {
    private val _userData = MutableLiveData<UserModel>()
    val userData = _userData

    fun fetchProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authRepository.getCurrentUser()
            _userData.postValue(response)
        }
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.signOut()
        }
    }
}
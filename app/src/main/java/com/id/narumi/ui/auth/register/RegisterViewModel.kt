package com.id.narumi.ui.auth.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.narumi.domain.Resource
import com.id.narumi.domain.auth.IAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: IAuthRepository
): ViewModel() {

    private val _message = MutableLiveData<String>()
    val message = _message

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.register(
                name = name,
                email = email,
                password = password
            )) {
                is Resource.Error -> {
                    _message.postValue(response.errorMessage)
                }
                is Resource.Success -> {
                    _message.postValue(response.data)
                }
            }
        }
    }
}
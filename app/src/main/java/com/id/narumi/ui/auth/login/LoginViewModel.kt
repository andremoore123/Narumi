package com.id.narumi.ui.auth.login

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.narumi.domain.Resource
import com.id.narumi.domain.analytic.IAnalyticRepository
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.utils.Utils.ANALYTIC_ONCLICK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: IAuthRepository,
    private val analyticRepository: IAnalyticRepository,
): ViewModel() {

    private val _message = MutableLiveData<String>()
    val message = _message

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = authRepository.login(email = email, password = password)) {
                is Resource.Error -> {
                    _message.postValue(response.errorMessage)
                }
                is Resource.Success -> {
                    _message.postValue(response.data)
                }
            }
        }
    }

    fun logScreen(screenName: String) {
        analyticRepository.logScreenView(screenName)
    }

    fun logButton(bundle: Bundle) {
        analyticRepository.logEvent(ANALYTIC_ONCLICK, bundle)
    }
}
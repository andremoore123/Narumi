package com.id.narumi

import androidx.lifecycle.ViewModel
import com.id.narumi.domain.auth.IAuthRepository

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class MainViewModel(
    private val authRepository: IAuthRepository
): ViewModel() {
    val authState = authRepository.observeLoginState()
}
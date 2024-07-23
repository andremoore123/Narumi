package com.id.narumi.domain.auth

import com.id.narumi.domain.Resource

/**
 * Created by: andreputras.
 * Date: 23/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
interface IAuthRepository {
    suspend fun login(email: String, password: String): Resource<String>
    suspend fun register(name: String, email: String, password: String): Resource<String>
    suspend fun signOut()

    fun getCurrentUser(): UserModel
}
package com.id.narumi.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.id.narumi.domain.Resource
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.auth.UserModel
import kotlinx.coroutines.tasks.await

/**
 * Created by: andreputras.
 * Date: 23/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class AuthRepository(
    private val firebaseAuth: FirebaseAuth
) : IAuthRepository {
    override suspend fun login(email: String, password: String): Resource<String> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user?.uid ?: "No User ID")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown Error")
        }
    }

    override suspend fun register(name: String, email: String, password: String): Resource<String> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.Success(result.user?.uid ?: "No User ID")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown Error")
        }
    }

    override suspend fun signOut() {
        firebaseAuth.signOut()
    }

    override fun getCurrentUser(): UserModel {
        val currentUser = firebaseAuth.currentUser
        return UserModel(
            name = currentUser?.displayName ?: "Not Set", email = currentUser?.email ?: "Empty Email"
        )
    }
}
package com.id.narumi.ui.auth.register

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.Resource
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.ui.auth.login.LoginViewModel
import com.id.narumi.util.getOrAwaitValue
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class RegisterViewModelTest {
    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var authRepository: IAuthRepository

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = RegisterViewModel(authRepository)
    }

    // Registering a user with valid name, email, and password should post success message
    @Test
    fun register_with_valid_credentials_posts_success_message() = runTest {
        // Arrange
        val name = "John Doe"
        val email = "john.doe@example.com"
        val password = "password123"
        val successMessage = "Registration successful"
        `when`(authRepository.register(name, email, password)).thenReturn(Resource.Success(successMessage))

        // Act
        viewModel.register(name, email, password)

        // Assert
        assertEquals(successMessage, viewModel.message.getOrAwaitValue(100))
    }

    // Registering with an empty name, email, or password should handle gracefully
    @Test
    fun register_with_empty_fields_handles_gracefully() = runTest {
        // Arrange
        val errorMessage = "Fields cannot be empty"
        `when`(authRepository.register("", "", "")).thenReturn(Resource.Error(errorMessage))

        // Act
        viewModel.register("", "", "")

        // Assert
        assertEquals(errorMessage, viewModel.message.getOrAwaitValue(100))
    }


}
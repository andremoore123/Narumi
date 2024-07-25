package com.id.narumi.ui.auth.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.Resource
import com.id.narumi.domain.analytic.IAnalyticRepository
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
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
@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var authRepository: IAuthRepository

    @Mock
    private lateinit var analyticRepository: IAnalyticRepository

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = LoginViewModel(authRepository, analyticRepository)
    }

    // Login with valid credentials updates message with success data
    @Test
    fun login_with_valid_credentials_updates_message_with_success_data() = runTest {
        // Arrange
        val email = "test@example.com"
        val password = "password123"
        val successMessage = "Login successful"
        `when`(authRepository.login(email, password)).thenReturn(Resource.Success(successMessage))

        viewModel.login(email, password)
        assertEquals(successMessage, viewModel.message.getOrAwaitValue(100))

    }

    // Login with empty email and password
    @Test
    fun login_with_empty_email_and_password() = runTest {
        // Arrange
        val email = ""
        val password = ""
        val errorMessage = "Email and password cannot be empty"
        `when`(authRepository.login(email, password)).thenReturn(Resource.Error(errorMessage))

        viewModel.login(email, password)
        assertEquals(errorMessage, viewModel.message.getOrAwaitValue(100))
    }
}
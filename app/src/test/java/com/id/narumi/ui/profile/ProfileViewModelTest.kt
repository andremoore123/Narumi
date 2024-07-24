package com.id.narumi.ui.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.auth.UserModel
import com.id.narumi.util.getOrAwaitValue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
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
class ProfileViewModelTest {
    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var authRepository: IAuthRepository

    private lateinit var viewModel: ProfileViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = ProfileViewModel(authRepository)
    }


    // Fetching profile data updates userData LiveData with current user information
    @Test
    fun fetch_profile_data_updates_user_data() {
        // Arrange
        val userModel = UserModel(name = "John Doe", email = "john.doe@example.com")
        `when`(authRepository.getCurrentUser()).thenReturn(userModel)
        val viewModel = ProfileViewModel(authRepository)

        // Act
        viewModel.fetchProfileData()

        // Assert
        assertEquals(userModel, viewModel.userData.getOrAwaitValue(100))
    }

    // fetchProfileData handles null or invalid user data gracefully
    @Test
    fun fetch_profile_data_handles_null_user_data() {
        // Arrange
        `when`(authRepository.getCurrentUser()).thenReturn(null)
        val viewModel = ProfileViewModel(authRepository)

        // Act
        viewModel.fetchProfileData()

        // Assert
        assertNull(viewModel.userData.value)
    }


}
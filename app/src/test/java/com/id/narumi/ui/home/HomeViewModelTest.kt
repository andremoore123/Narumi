package com.id.narumi.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.auth.UserModel
import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripModel
import com.id.narumi.ui.profile.ProfileViewModel
import com.id.narumi.util.getOrAwaitValue
import com.id.narumi.utils.TripCategories
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
class HomeViewModelTest {
    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var authRepository: IAuthRepository

    @Mock
    private lateinit var tripRepository: ITripRepository

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = HomeViewModel(tripRepository, authRepository)
    }

    // Fetching all data populates popular, recommended, all trips, and user data lists
    @Test
    fun fetch_all_data_populates_all_lists() {
        // Arrange
        val trips = listOf(TripModel("1", 0, "Trip1", "Location1", "Date1", "OrderDate1", "Duration1", 100, "Description1", "Popular"))
        val user = UserModel("User1", "user1@example.com")

        `when`(tripRepository.fetchTrips()).thenReturn(trips)
        `when`(tripRepository.fetchTripByCategory(TripCategories.Popular.value)).thenReturn(trips)
        `when`(tripRepository.fetchTripByCategory(TripCategories.Recommended.value)).thenReturn(trips)
        `when`(authRepository.getCurrentUser()).thenReturn(user)

        // Act
        viewModel.fetchAllData()

        // Assert
        assertEquals(trips, viewModel.popularList.getOrAwaitValue(100))
        assertEquals(trips, viewModel.recommendedList.getOrAwaitValue(100))
        assertEquals(trips, viewModel.allTrips.getOrAwaitValue(100))
        assertEquals(user, viewModel.userData.getOrAwaitValue(100))
    }

    // Fetching data when repositories return empty lists
    @Test
    fun fetch_data_with_empty_repositories() {
        // Arrange
        val emptyTrips = emptyList<TripModel>()
        val user = UserModel("User1", "user1@example.com")

        `when`(tripRepository.fetchTrips()).thenReturn(emptyTrips)
        `when`(tripRepository.fetchTripByCategory(TripCategories.Popular.value)).thenReturn(emptyTrips)
        `when`(tripRepository.fetchTripByCategory(TripCategories.Recommended.value)).thenReturn(emptyTrips)
        `when`(authRepository.getCurrentUser()).thenReturn(user)

        // Act
        viewModel.fetchAllData()

        // Assert
        assertTrue(viewModel.popularList.getOrAwaitValue(100)!!.isEmpty())
        assertTrue(viewModel.recommendedList.getOrAwaitValue(100)!!.isEmpty())
        assertTrue(viewModel.allTrips.getOrAwaitValue(100)!!.isEmpty())
        assertEquals(user, viewModel.userData.getOrAwaitValue(100))
    }

}
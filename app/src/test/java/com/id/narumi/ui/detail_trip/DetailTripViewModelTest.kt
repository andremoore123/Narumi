package com.id.narumi.ui.detail_trip

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripModel
import com.id.narumi.util.getOrAwaitValue
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
class DetailTripViewModelTest {
    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tripRepository: ITripRepository

    private lateinit var viewModel: DetailTripViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = DetailTripViewModel(tripRepository)
    }


    // fetchTripById successfully retrieves a trip and updates tripData
    @Test
    fun fetch_trip_by_id_success() {
        // Arrange
        val tripModel = TripModel(
            uuid = "123",
            imageResId = 1,
            name = "Trip to Bali",
            location = "Bali",
            date = "2023-10-01",
            orderDate = "2023-09-01",
            duration = "7 days",
            cost = 1000,
            description = "A wonderful trip to Bali",
            category = "Vacation"
        )
        `when`(tripRepository.fetchTripById("123")).thenReturn(tripModel)

        // Act
        viewModel.fetchTripById("123")

        // Assert
        assertEquals(tripModel, viewModel.tripData.getOrAwaitValue(100))
    }

    // fetchTripById is called with an invalid or non-existent ID
    @Test
    fun fetch_trip_by_id_invalid_id() {
        // Arrange
        `when`(tripRepository.fetchTripById("invalid_id")).thenReturn(null)

        // Act
        viewModel.fetchTripById("invalid_id")

        // Assert
        assertNull(viewModel.tripData.value)
    }


}
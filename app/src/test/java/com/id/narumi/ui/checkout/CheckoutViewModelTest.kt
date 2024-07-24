package com.id.narumi.ui.checkout

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.transaction.ITransactionRepository
import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripModel
import com.id.narumi.ui.profile.ProfileViewModel
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
class CheckoutViewModelTest {
    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tripRepository: ITripRepository

    @Mock
    private lateinit var transactionRepository: ITransactionRepository

    private lateinit var viewModel: CheckoutViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = CheckoutViewModel(tripRepository, transactionRepository)
    }


    // Fetch trip data by ID and update LiveData
    @Test
    fun fetch_trip_by_id_updates_live_data() {
        // Arrange
        val tripId = "123"
        val tripModel = TripModel(
            uuid = tripId,
            imageResId = 0,
            name = "Trip Name",
            location = "Location",
            date = "2023-10-10",
            orderDate = "2023-10-01",
            duration = "7 days",
            cost = 1000,
            description = "Description",
            category = "Category"
        )
        `when`(tripRepository.fetchTripById(tripId)).thenReturn(tripModel)

        // Act
        viewModel.fetchTripById(tripId)
        Thread.sleep(100) // Wait for coroutine to finish

        // Assert
        assertEquals(tripModel, viewModel.tripData.value)
    }

    // Fetch trip by ID when trip does not exist
    @Test
    fun fetch_trip_by_id_when_trip_does_not_exist() {
        // Arrange
        val tripId = "nonexistent"
        `when`(tripRepository.fetchTripById(tripId)).thenReturn(null)

        // Act
        viewModel.fetchTripById(tripId)
        Thread.sleep(100) // Wait for coroutine to finish

        // Assert
        assertNull(viewModel.tripData.value)
    }



}
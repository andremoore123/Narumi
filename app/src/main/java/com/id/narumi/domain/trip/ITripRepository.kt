package com.id.narumi.domain.trip

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
interface ITripRepository {
    fun fetchTrips(): List<TripModel>
    fun fetchTripByCategory(category: String): List<TripModel>
    fun fetchTripById(id: String): TripModel?
}
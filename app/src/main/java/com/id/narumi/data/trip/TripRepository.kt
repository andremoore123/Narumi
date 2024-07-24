package com.id.narumi.data.trip

import com.id.narumi.domain.trip.ITripRepository
import com.id.narumi.domain.trip.TripMapper.mapTripResponseToModel
import com.id.narumi.domain.trip.TripModel

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class TripRepository: ITripRepository {
    private val source = DummyDataProvider.getTripResponses()
    override fun fetchTrips(): List<TripModel> {
        return source.map {
            mapTripResponseToModel(it)
        }
    }

    override fun fetchTripByCategory(category: String): List<TripModel> {
        return source.filter { it.category == category }.map {
            mapTripResponseToModel(it)
        }
    }
}
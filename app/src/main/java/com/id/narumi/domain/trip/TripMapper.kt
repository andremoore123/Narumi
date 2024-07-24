package com.id.narumi.domain.trip

import com.id.narumi.data.transaction.model.TransactionEntity
import com.id.narumi.data.trip.model.TripResponse

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
object TripMapper {
    fun mapTripResponseToModel(q: TripResponse) = TripModel(
        uuid = q.uuid,
        imageResId = q.imageResId,
        name = q.name,
        location = q.location,
        date = q.date,
        orderDate = q.orderDate,
        duration = q.duration,
        cost = q.cost,
        description = q.description,
        category = q.category
    )

    fun mapTripModelToTransaction(q: TripModel, totalCost: Int) = TransactionEntity(
        uuid = q.uuid,
        imageResId = q.imageResId,
        name = q.name,
        location = q.location,
        orderDate = q.orderDate,
        duration = q.duration,
        totalCost = totalCost
    )
}
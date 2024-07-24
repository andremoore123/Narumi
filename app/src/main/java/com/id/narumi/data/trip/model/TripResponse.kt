package com.id.narumi.data.trip.model

import java.util.UUID

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
data class TripResponse(
    val uuid: String = UUID.randomUUID().toString(),
    val imageResId: Int,
    val name: String,
    val location: String,
    val date: String,
    val orderDate: String,
    val duration: String,
    val cost: Int,
    val description: String,
    val category: String
)

package com.id.narumi.domain.trip

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
data class TripModel(
    val uuid: String,
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

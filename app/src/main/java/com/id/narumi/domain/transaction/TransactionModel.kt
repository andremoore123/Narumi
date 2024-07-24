package com.id.narumi.domain.transaction

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
data class TransactionModel(
    val uuid: String,
    val imageResId: Int,
    val name: String,
    val location: String,
    val orderDate: String,
    val duration: String,
    val totalCost: Int,
)

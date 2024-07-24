package com.id.narumi.data.transaction.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey
    val uuid: String,
    val imageResId: Int,
    val name: String,
    val location: String,
    val orderDate: String,
    val duration: String,
    val totalCost: Int,
)

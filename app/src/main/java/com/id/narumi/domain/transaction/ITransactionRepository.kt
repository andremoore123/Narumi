package com.id.narumi.domain.transaction

import com.id.narumi.domain.trip.TripModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
interface ITransactionRepository {
    suspend fun checkout(tripData: TripModel, totalCost: Int)
    fun fetchTransactions(): Flow<List<TransactionModel>>

}
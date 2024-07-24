package com.id.narumi.data.transaction

import com.id.narumi.di.AppDatabase
import com.id.narumi.domain.transaction.ITransactionRepository
import com.id.narumi.domain.transaction.TransactionMapper.mapEntityToModel
import com.id.narumi.domain.transaction.TransactionModel
import com.id.narumi.domain.trip.TripMapper.mapTripModelToTransaction
import com.id.narumi.domain.trip.TripModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class TransactionRepository(
    private val database: AppDatabase,
) : ITransactionRepository {
    private val transactionDao = database.transactionDao()
    override suspend fun checkout(tripData: TripModel, totalCost: Int) {
        val transaction = mapTripModelToTransaction(tripData, totalCost)
        transactionDao.addTransaction(transaction)
    }

    override fun fetchTransactions(): Flow<List<TransactionModel>> =
        transactionDao.fetchTransactions().map { transactionEntities ->
            transactionEntities.map {
                mapEntityToModel(it)
            }
        }
}
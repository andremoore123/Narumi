package com.id.narumi.data.transaction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.id.narumi.data.transaction.model.TransactionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
@Dao
interface TransactionDao {
    @Query("SELECT * FROM `transaction`")
    fun fetchTransactions(): Flow<List<TransactionEntity>>

    @Insert
    fun addTransaction(data: TransactionEntity)
}
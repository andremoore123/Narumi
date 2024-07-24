package com.id.narumi.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.id.narumi.data.transaction.TransactionDao
import com.id.narumi.data.transaction.model.TransactionEntity

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
@Database(entities = [TransactionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}
package com.id.narumi.di

import androidx.room.Room
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.id.narumi.base.BaseModule
import com.id.narumi.data.analytic.AnalyticRepository
import com.id.narumi.data.auth.AuthRepository
import com.id.narumi.data.transaction.TransactionRepository
import com.id.narumi.data.trip.TripRepository
import com.id.narumi.domain.analytic.IAnalyticRepository
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.transaction.ITransactionRepository
import com.id.narumi.domain.trip.ITripRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by: andreputras.
 * Date: 23/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
object DatabaseModule: BaseModule {
    private val firebaseModule = module {
        single { FirebaseAuth.getInstance() }
        single { FirebaseAnalytics.getInstance(get()) }
    }

    private val roomModule = module {
        single {
            Room.databaseBuilder(androidContext(), AppDatabase::class.java, "narumi_database")
                .build()
        }
    }
    private val repositoryModule = module {
        single<IAuthRepository> { AuthRepository(get()) }
        single<ITripRepository> { TripRepository() }
        single<ITransactionRepository> { TransactionRepository(get()) }
        single<IAnalyticRepository> { AnalyticRepository(get()) }
    }


    override fun getModules(): List<Module> {
        return listOf(
            firebaseModule,
            repositoryModule,
            roomModule,
        )
    }
}
package com.id.narumi.di

import com.google.firebase.auth.FirebaseAuth
import com.id.narumi.base.BaseModule
import com.id.narumi.data.auth.AuthRepository
import com.id.narumi.data.trip.TripRepository
import com.id.narumi.domain.auth.IAuthRepository
import com.id.narumi.domain.trip.ITripRepository
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
    }

    private val repositoryModule = module {
        single<IAuthRepository> { AuthRepository(get()) }
        single<ITripRepository> { TripRepository() }
    }

    override fun getModules(): List<Module> {
        return listOf(
            firebaseModule,
            repositoryModule,
        )
    }
}
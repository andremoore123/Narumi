package com.id.narumi.di

import com.id.narumi.MainActivity
import com.id.narumi.MainViewModel
import com.id.narumi.base.BaseModule
import com.id.narumi.ui.auth.login.LoginFragment
import com.id.narumi.ui.auth.login.LoginViewModel
import com.id.narumi.ui.auth.register.RegisterFragment
import com.id.narumi.ui.auth.register.RegisterViewModel
import com.id.narumi.ui.home.HomeFragment
import com.id.narumi.ui.home.HomeViewModel
import com.id.narumi.ui.profile.ProfileFragment
import com.id.narumi.ui.profile.ProfileViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by: andreputras.
 * Date: 23/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
object AppModule: BaseModule {
    private val viewModelModules = module {
        scope<LoginFragment> {scoped { LoginViewModel(get()) }}
        scope<MainActivity> { scoped { MainViewModel(get()) } }
        scope<RegisterFragment> { scoped { RegisterViewModel(get()) } }
        scope<HomeFragment> { scoped { HomeViewModel(get(), get()) } }
        scope<ProfileFragment> { scoped { ProfileViewModel(get()) } }
    }

    override fun getModules(): List<Module> {
        return listOf(
            viewModelModules
        )
    }

}
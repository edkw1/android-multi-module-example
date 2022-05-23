package com.example.multimodule.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class GlobalNavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}
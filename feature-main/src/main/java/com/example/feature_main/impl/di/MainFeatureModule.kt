package com.example.feature_main.impl.di

import com.example.feature_main.api.MainFeatureStarter
import dagger.Binds
import dagger.Module

@Module
internal interface MainFeatureModule {

    @Binds
    fun provideStarter(mainFeatureStarterImpl: MainFeatureStarterImpl): MainFeatureStarter
}
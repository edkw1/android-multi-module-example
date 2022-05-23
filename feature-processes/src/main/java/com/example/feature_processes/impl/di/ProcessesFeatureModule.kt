package com.example.feature_processes.impl.di

import com.example.feature_processes.api.ProcessesFeatureStarter
import com.example.feature_processes.impl.ProcessesStarterImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ProcessesFeatureModule {

    @Binds
    fun provideProcessesStarter(proFeProcessesStarterImpl: ProcessesStarterImpl): ProcessesFeatureStarter
}
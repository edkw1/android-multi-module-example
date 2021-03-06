package com.example.feature_main.impl.di

import androidx.lifecycle.ViewModel
import com.example.feature_main.impl.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {
    @IntoMap
    @StringKey("MainViewModel")
    @Binds
    fun bindExampleViewModel(impl: MainViewModel): ViewModel
}
package com.example.feature_main.di

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideHelloString(): String{
        return "Hello!";
    }

}
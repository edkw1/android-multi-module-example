package com.example.feature_main.impl.di

import dagger.Module
import dagger.Provides

@Module
class StringTestModule {

    @Provides
    fun provideHelloString(): String{
        return "Hello!";
    }
}
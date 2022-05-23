package com.example.feature_main.impl.di

import com.example.module_injector.BaseDependencies
import com.github.terrakok.cicerone.Router

interface MainFeatureDependencies: BaseDependencies {
    fun router(): Router
}
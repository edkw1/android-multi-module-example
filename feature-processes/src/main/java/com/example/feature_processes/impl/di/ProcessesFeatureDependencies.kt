package com.example.feature_processes.impl.di

import com.example.module_injector.BaseDependencies
import com.github.terrakok.cicerone.Router

interface ProcessesFeatureDependencies: BaseDependencies {
    fun router(): Router
}
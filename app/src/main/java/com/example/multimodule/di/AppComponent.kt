package com.example.multimodule.di

import com.example.multimodule.App
import com.example.multimodule.MainActivity
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Singleton
@Component(modules = [GlobalNavigationModule::class, MainModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}
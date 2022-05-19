package com.example.feature_main.di

import android.content.Context
import com.example.feature_main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@ApplicationScope
@Component(modules = [MainModule::class, ViewModelModule::class])
interface MainComponent {

    fun inject(mainFragment: MainFragment)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long
        ): MainComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
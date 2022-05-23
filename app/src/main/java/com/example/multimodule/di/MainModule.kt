package com.example.multimodule.di

import com.example.feature_main.api.MainFeatureApi
import com.example.feature_main.impl.di.MainFeatureComponentHolder
import com.example.feature_main.impl.di.MainFeatureDependencies
import com.example.feature_processes.api.ProcessesFeatureApi
import com.example.feature_processes.impl.di.ProcessesFeatureComponentHolder
import com.example.feature_processes.impl.di.ProcessesFeatureDependencies
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideProcessFeatureDependencies(router: Router): ProcessesFeatureDependencies {
        return object : ProcessesFeatureDependencies {
            override fun router() = router
        }
    }

    @Provides
    fun provideMainFeatureDependencies(router: Router): MainFeatureDependencies {
        return object : MainFeatureDependencies {
            override fun router() = router
        }
    }

    @Provides
    fun provideMainFeatureModule(dependencies: MainFeatureDependencies): MainFeatureApi {
        MainFeatureComponentHolder.init(dependencies)
        return MainFeatureComponentHolder.get()
    }

    @Provides
    fun provideProcessesFeatureModule(dependencies: ProcessesFeatureDependencies): ProcessesFeatureApi {
        ProcessesFeatureComponentHolder.init(dependencies)
        return ProcessesFeatureComponentHolder.get()
    }
}
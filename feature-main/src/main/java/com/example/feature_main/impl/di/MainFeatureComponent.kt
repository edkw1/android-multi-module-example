package com.example.feature_main.impl.di

import com.example.feature_main.api.MainFeatureApi
import com.example.feature_main.impl.presentation.MainFragment
import dagger.Component
import ru.ufanet.erpmobile.PerFeature

@PerFeature
@Component(modules = [MainFeatureModule::class, ViewModelModule::class, StringTestModule::class], dependencies = [MainFeatureDependencies::class])
internal abstract class MainFeatureComponent: MainFeatureApi {

    internal abstract fun inject(mainFragment: MainFragment)

    companion object{
        fun initAndGet(mainFeatureDependencies: MainFeatureDependencies): MainFeatureComponent{
            return DaggerMainFeatureComponent.builder()
                .mainFeatureDependencies(mainFeatureDependencies)
                .build()
        }
    }
}
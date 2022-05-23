package com.example.feature_main.impl.di

import com.example.feature_main.api.MainFeatureApi
import com.example.module_injector.ComponentHolder

object MainFeatureComponentHolder: ComponentHolder<MainFeatureApi, MainFeatureDependencies> {
    private var mainFeatureComponent: MainFeatureComponent? = null

    override fun init(dependencies: MainFeatureDependencies) {
        if(mainFeatureComponent == null){
            synchronized(MainFeatureComponentHolder::class.java){
                if(mainFeatureComponent == null){
                    mainFeatureComponent = MainFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): MainFeatureApi {
        checkNotNull(mainFeatureComponent) { "MainFeature not initialized" }
        return mainFeatureComponent!!
    }

    override fun reset() {
        mainFeatureComponent = null
    }
}
package com.example.feature_processes.impl.di

import com.example.feature_processes.api.ProcessesFeatureApi
import com.example.module_injector.ComponentHolder

object ProcessesFeatureComponentHolder: ComponentHolder<ProcessesFeatureApi, ProcessesFeatureDependencies> {
    private var processesFeatureComponent: ProcessesFeatureComponent? = null

    override fun init(dependencies: ProcessesFeatureDependencies) {
        if(processesFeatureComponent == null){
            synchronized(ProcessesFeatureComponentHolder::class.java){
                if(processesFeatureComponent == null){
                    processesFeatureComponent = ProcessesFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ProcessesFeatureApi {
        checkNotNull(processesFeatureComponent){ "processesFeatureComponent not initialized!! " }
        return processesFeatureComponent!!
    }

    override fun reset() {
        processesFeatureComponent = null
    }
}
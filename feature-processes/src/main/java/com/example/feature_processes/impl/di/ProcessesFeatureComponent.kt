package com.example.feature_processes.impl.di

import com.example.feature_processes.ProcessesFragment
import com.example.feature_processes.api.ProcessesFeatureApi
import dagger.Component


@Component(
    modules = [ProcessesFeatureModule::class],
    dependencies = [ProcessesFeatureDependencies::class]
)
internal abstract class ProcessesFeatureComponent : ProcessesFeatureApi {

    internal abstract fun inject(processesFragment: ProcessesFragment)

    companion object {

        fun initAndGet(processesFeatureDependencies: ProcessesFeatureDependencies): ProcessesFeatureComponent {
            return DaggerProcessesFeatureComponent.builder()
                .processesFeatureDependencies(processesFeatureDependencies)
                .build()

        }
    }
}
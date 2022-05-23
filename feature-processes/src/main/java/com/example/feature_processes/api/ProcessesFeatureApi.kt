package com.example.feature_processes.api

import com.example.module_injector.BaseAPI

interface ProcessesFeatureApi: BaseAPI {
    fun processesFeatureStarter(): ProcessesFeatureStarter
}
package com.example.feature_main.api

import com.example.module_injector.BaseAPI

interface MainFeatureApi: BaseAPI {

    fun mainFeatureStarter(): MainFeatureStarter
}
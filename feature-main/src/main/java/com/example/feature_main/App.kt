package com.example.feature_main

import android.app.Application
import com.example.feature_main.di.DaggerMainComponent

class App: Application() {

    val component by lazy {
        DaggerMainComponent.factory().create(this, System.currentTimeMillis())
    }
}
package com.example.multimodule

import android.app.Application
import com.example.multimodule.di.AppComponent
import com.example.multimodule.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.init(
            DaggerAppComponent.builder().build()
        )
        AppComponent.get().inject(this)
    }
}
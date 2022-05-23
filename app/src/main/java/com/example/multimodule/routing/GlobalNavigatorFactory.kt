package com.example.multimodule.routing

import androidx.fragment.app.FragmentActivity
import dagger.assisted.AssistedFactory

@AssistedFactory
interface GlobalNavigatorFactory {
    fun create(
        activity: FragmentActivity,
        containerId: Int,
    ): GlobalNavigator
}
package com.example.feature_main.impl.di

import com.example.feature_main.api.MainFeatureStarter
import com.example.feature_main.impl.presentation.MainFragment
import javax.inject.Inject

internal class MainFeatureStarterImpl @Inject constructor() : MainFeatureStarter {
    override fun fragment() = MainFragment()
}
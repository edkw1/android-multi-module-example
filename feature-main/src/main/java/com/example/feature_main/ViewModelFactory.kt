package com.example.feature_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_main.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ViewModelFactory @Inject constructor(
    private val viewModels: @JvmSuppressWildcards Map<String, ViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModels[modelClass.simpleName] as T
    }
}
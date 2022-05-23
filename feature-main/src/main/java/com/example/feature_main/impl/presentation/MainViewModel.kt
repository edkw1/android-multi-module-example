package com.example.feature_main.impl.presentation

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hello: String
): ViewModel() {

    init {
        println("init vm")
    }

    override fun onCleared() {
        super.onCleared()
        println("cleared vm")
    }

    fun str() = hello+" "+this
}
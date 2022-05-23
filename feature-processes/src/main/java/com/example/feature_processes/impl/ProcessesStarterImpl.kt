package com.example.feature_processes.impl

import com.example.feature_processes.ProcessesFragment
import com.example.feature_processes.api.ProcessesFeatureStarter
import javax.inject.Inject

class ProcessesStarterImpl @Inject constructor(): ProcessesFeatureStarter{

    override fun fragment() = ProcessesFragment()
}
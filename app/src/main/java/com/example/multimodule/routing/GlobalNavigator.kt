package com.example.multimodule.routing

import androidx.fragment.app.FragmentActivity
import com.example.feature_main.api.MainFeatureApi
import com.example.feature_processes.api.ProcessesFeatureApi
import com.github.terrakok.cicerone.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ru.ufanet.erpmobile.GlobalScreenNames
import javax.inject.Provider

class GlobalNavigator @AssistedInject constructor(
    @Assisted private val activity: FragmentActivity,
    @Assisted private val containerId: Int,
    private val featureMain: Provider<MainFeatureApi>,
    private val featureProcesses: Provider<ProcessesFeatureApi>,
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        commands.forEach {
            applyCommand(it)
        }
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Back -> back()
        }
    }

    private fun back() {
        if (activity.supportFragmentManager.backStackEntryCount == 0) {
            activity.finish()
        }
    }

    private fun forward(command: Forward) {
        val name = command.screen
        startFeatureStartPoint(name)
    }

    private fun startFeatureStartPoint(screen: Screen) {
        val fragment = when (screen) {
            GlobalScreenNames.MainFeatureScreen -> {
                featureMain.get().mainFeatureStarter().fragment()
            }
            GlobalScreenNames.ProcessesFeatureScreen -> {
                featureProcesses.get().processesFeatureStarter().fragment()
            }
            else -> throw RuntimeException("Unexpected screen: $screen")
        }
        activity.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
}
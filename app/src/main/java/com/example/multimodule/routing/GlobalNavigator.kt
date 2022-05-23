package com.example.multimodule.routing

import androidx.fragment.app.FragmentActivity
import com.example.feature_main.api.MainFeatureApi
import com.example.feature_processes.api.ProcessesFeatureApi
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ru.ufanet.erpmobile.GlobalScreenNames
import javax.inject.Provider

class GlobalNavigator @AssistedInject constructor(
    @Assisted activity: FragmentActivity,
    @Assisted containerId: Int,
    private val featureMain: Provider<MainFeatureApi>,
    private val featureProcesses: Provider<ProcessesFeatureApi>,
) : AppNavigator(activity, containerId) {

    override fun applyCommands(commands: Array<out Command>) {
        commands.forEach {
            applyCmd(it)
        }
    }

    private fun applyCmd(command: Command) {
        if (command is Forward) {
            fwd(command)
            return
        }
    }

    private fun fwd(command: Forward) {
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
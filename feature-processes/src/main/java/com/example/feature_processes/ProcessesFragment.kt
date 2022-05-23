package com.example.feature_processes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature_processes.databinding.FragmentProcessesBinding
import com.example.feature_processes.impl.di.ProcessesFeatureComponent
import com.example.feature_processes.impl.di.ProcessesFeatureComponentHolder
import com.github.terrakok.cicerone.Router
import ru.ufanet.erpmobile.GlobalScreenNames
import javax.inject.Inject

class ProcessesFragment : Fragment() {
    lateinit var binding: FragmentProcessesBinding

    @Inject
    lateinit var router: Router

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProcessesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (ProcessesFeatureComponentHolder.get() as ProcessesFeatureComponent).inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prev.setOnClickListener {
            router.navigateTo(GlobalScreenNames.MainFeatureScreen)
        }
        println("args: processId = " + arguments?.getString("processId") +" type = " +  arguments?.getInt("typeId"))
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProcessesFragment()
    }
}
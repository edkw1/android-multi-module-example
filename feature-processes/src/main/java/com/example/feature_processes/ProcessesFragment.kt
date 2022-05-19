package com.example.feature_processes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.feature_processes.databinding.FragmentProcessesBinding

class ProcessesFragment : Fragment() {
    lateinit var binding: FragmentProcessesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProcessesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prev.setOnClickListener {
            findNavController().popBackStack()
        }
        println("args: processId = " + arguments?.getString("processId") +" type = " +  arguments?.getInt("typeId"))
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProcessesFragment()
    }
}
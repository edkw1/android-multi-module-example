package com.example.feature_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.feature_main.databinding.FragmentMainBinding
import com.example.feature_main.di.DaggerMainComponent
import javax.inject.Inject

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (activity?.application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Message: " + viewModel.str())
        binding.next.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri(
                    "android-app://com.example.app/processes_fragment".toUri().buildUpon()
                        .appendQueryParameter("processId", "12354")
                        .appendQueryParameter("typeId", "12222")
                        .build()
                )
                .build()
            findNavController().navigate(request)
        }
    }
}
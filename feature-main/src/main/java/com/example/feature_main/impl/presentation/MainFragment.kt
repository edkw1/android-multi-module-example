package com.example.feature_main.impl.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.feature_main.databinding.FragmentMainBinding
import com.example.feature_main.impl.di.MainFeatureComponent
import com.example.feature_main.impl.di.MainFeatureComponentHolder
import com.github.terrakok.cicerone.Router
import ru.ufanet.erpmobile.GlobalScreenNames
import ru.ufanet.erpmobile.ViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (MainFeatureComponentHolder.get() as MainFeatureComponent).inject(this)
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
            router.navigateTo(GlobalScreenNames.ProcessesFeatureScreen)
        }
    }
}
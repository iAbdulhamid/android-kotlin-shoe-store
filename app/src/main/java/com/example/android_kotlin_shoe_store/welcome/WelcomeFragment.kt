package com.example.android_kotlin_shoe_store.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android_kotlin_shoe_store.MainViewModel
import com.example.android_kotlin_shoe_store.R
import com.example.android_kotlin_shoe_store.databinding.FragmentWelcomeBinding
import com.example.android_kotlin_shoe_store.instructions.InstructionsFragmentDirections
import com.example.android_kotlin_shoe_store.login.LoginFragmentDirections


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        binding.viewModel = viewModel

        viewModel.eventShowInstructionScreen.observe(viewLifecycleOwner, Observer { showInstScreen ->
            if (showInstScreen) {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
                viewModel.onEventShowInstructionScreenComplete()
            }

        })

        return binding.root
    }
}
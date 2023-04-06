package com.example.android_kotlin_shoe_store.login

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
import com.example.android_kotlin_shoe_store.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate(
           inflater,
           R.layout.fragment_login,
           container,
           false
       )

        binding.viewModel = viewModel
        viewModel.eventShowWelcomeScreen.observe(viewLifecycleOwner, Observer { show ->
            if (show) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.onEventShowWelcomeScreenComplete()
            }
        })

        return binding.root
    }
}
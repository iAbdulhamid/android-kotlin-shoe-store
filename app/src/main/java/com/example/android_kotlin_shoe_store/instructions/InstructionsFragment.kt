package com.example.android_kotlin_shoe_store.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android_kotlin_shoe_store.MainViewModel
import com.example.android_kotlin_shoe_store.R
import com.example.android_kotlin_shoe_store.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )

        binding.viewModel = viewModel

        viewModel.eventShowShoeListScreen.observe(viewLifecycleOwner, Observer { showShoeListScreen ->
                if (showShoeListScreen) {
                    findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
                    viewModel.onEventShowShowListScreenComplete()
                }
        })

        return binding.root
    }
}

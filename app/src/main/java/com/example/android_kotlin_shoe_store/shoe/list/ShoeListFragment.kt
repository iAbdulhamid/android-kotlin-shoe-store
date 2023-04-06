package com.example.android_kotlin_shoe_store.shoe.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android_kotlin_shoe_store.MainViewModel
import com.example.android_kotlin_shoe_store.R
import com.example.android_kotlin_shoe_store.databinding.FragmentShoeListBinding
import com.example.android_kotlin_shoe_store.databinding.ShoeListItemBinding
import com.example.android_kotlin_shoe_store.instructions.InstructionsFragmentDirections
import com.example.android_kotlin_shoe_store.login.LoginFragmentDirections


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: MainViewModel by activityViewModels()

    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes?.let {
                it.forEach {
                    val shoeListItemBinding: ShoeListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_list_item, null, false)

                    shoeListItemBinding.nameTextView.text = getString(R.string.string_value, "Shoe name:", it.name)
                    shoeListItemBinding.companyTextView.text = getString(R.string.string_value, "Company name:", it.company)
                    shoeListItemBinding.sizeTextView.text = getString(R.string.double_value, "Shoe size:", it.size)
                    shoeListItemBinding.descriptionTextView.text = getString(R.string.string_value, "Description:", it.description)

                    binding.linearLayout.addView(shoeListItemBinding.root)
                }
            }
        })


        binding.addShoe.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.shoe_list_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}
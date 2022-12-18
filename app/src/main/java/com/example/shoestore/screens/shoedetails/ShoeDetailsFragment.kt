package com.example.shoestore.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.SharedViewModel
import com.example.shoestore.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false
        )
        binding.shoe = sharedViewModel.shoe


        binding.save.setOnClickListener { view->
            sharedViewModel.onSaveShoe()
            view.findNavController().navigateUp()
        }

        binding.cancel.setOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        return binding.root
    }

}
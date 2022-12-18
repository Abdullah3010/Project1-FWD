package com.example.shoestore.screens.shoelistings

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.SharedViewModel
import com.example.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.shoestore.databinding.FragmentShoeListingsBinding

class ShoeListingsFragment :Fragment() {


    private lateinit var binding: FragmentShoeListingsBinding
    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listings, container, false
        )

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.loginFragment -> findNavController().navigate(ShoeListingsFragmentDirections.actionShoeListingsToLogin())
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        sharedViewModel.onSave.observe(viewLifecycleOwner){ isSave ->
            if(isSave){
                for (shoe in sharedViewModel.shoes){
                    val view :View = layoutInflater.inflate(R.layout.shoe_itm,null)
                    view.id = shoe.id
                    val shoeName : TextView =view.findViewById(R.id.shoeName)
                    val shoeSize : TextView =view.findViewById(R.id.shoeSize)
                    val shoeCompany : TextView =view.findViewById(R.id.shoeCompany)
                    val shoeDescription : TextView =view.findViewById(R.id.shoeDescription)
                    shoeName.text = shoe.name
                    shoeSize.text = shoe.size.toString()
                    shoeCompany.text = shoe.company
                    shoeDescription.text = shoe.description
                    binding.myShoeList.addView(view)
                }
                sharedViewModel.onSaveShoeDone()
            }

        }

        binding.shoeListingFab.setOnClickListener { view ->
            view.findNavController().navigate(ShoeListingsFragmentDirections.actionShoeListingsToShoeDetails())
        }
        return binding.root
    }


}
package com.example.clase09.navigation

import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.example.clase09.MainActivity
import com.example.clase09.R
import com.example.clase09.covidCases.CovidCaseDetailFragment
import com.example.clase09.covidCases.CovidCasesFragmentDirections

class Navigator(val activity: MainActivity?) {

    fun navigateToDetail(countryId: String){
        val action = CovidCasesFragmentDirections.actionToCovidCaseDetailFragment(countryId)
        activity?.findNavController(R.id.fragment_container)?.navigate(action)
    }

    fun navigateToFavorites(){
        activity?.findNavController(R.id.fragment_container)?.navigate(R.id.action_to_favoritesFragment)
    }

    fun navigateUp(){
        activity?.findNavController(R.id.fragment_container)?.popBackStack()
    }

}
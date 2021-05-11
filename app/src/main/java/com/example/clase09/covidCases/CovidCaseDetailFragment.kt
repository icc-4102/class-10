package com.example.clase09.covidCases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.clase09.R

class CovidCaseDetailFragment : Fragment() {

    private val viewModel: CovidCasesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_covid_case_detail, container, false)
        viewModel.selectedCase.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.titleLabel).text =
                    "Covid Case Detail from ${it.country}"
            view.findViewById<TextView>(R.id.deathLabel).text = "Deaths:  ${it.deaths}"
            view.findViewById<TextView>(R.id.positiveLabel).text = "Active:  ${it.active}"
            view.findViewById<TextView>(R.id.negativeLabel).text = "Recovered:  ${it.recovered}"
        })
        val favoriteButton  = view.findViewById<Button>(R.id.save_favorite_button)
        favoriteButton.setOnClickListener {
            if (viewModel.selectedCase.value != null ){
                viewModel.addCase(viewModel.selectedCase.value !!)
            }
        }
        val closeButton = view.findViewById<Button>(R.id.close_button)
        closeButton.setOnClickListener {
            val result = "result of fragment"
            setFragmentResult("REQUEST", bundleOf("DATA" to result))
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }


}
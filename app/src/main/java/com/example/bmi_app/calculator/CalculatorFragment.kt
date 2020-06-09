package com.example.bmi_app.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bmi_app.R
import com.example.bmi_app.databinding.FragmentCalculatorBinding

class CalculatorFragment: Fragment() {

    lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculator, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        binding.viewModel = viewModel

        registerObservers()

        return binding.root
    }

    private fun registerObservers(){
        // Navigate to ResultFragment
        viewModel.navigateToResultFragment.observe(viewLifecycleOwner, Observer {
            if(it){
                val action = CalculatorFragmentDirections.actionCalculatorFragment3ToResultFragment()
                this.findNavController()?.navigate(action)
                viewModel.navigationDone()
            }
        })
    }
}

data class BMI(val bmi: Double, val tip: String, val color: Int){}
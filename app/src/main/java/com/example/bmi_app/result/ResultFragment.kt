package com.example.bmi_app.result

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.bmi_app.R
import com.example.bmi_app.databinding.FragmentResultBinding

class ResultFragment: Fragment() {

    lateinit var viewModel: ResultViewModel
    private lateinit var viewModelFactory: ResultViewModelFactory
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        binding.lifecycleOwner = this

        val bmiData = ResultFragmentArgs.fromBundle(requireArguments()).bmiData
        viewModelFactory = ResultViewModelFactory(bmiData)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ResultViewModel::class.java)
        binding.viewModel = viewModel

        registerObservers()

        return binding.root
    }

    private fun registerObservers(){
        // Navigate back to Calculator
        viewModel.navigateToCalculatorFragment.observe(viewLifecycleOwner, Observer {
            Log.i("ResultFragment", "Navigates to Calculator Fragment!")
            if(it){
                val action = ResultFragmentDirections.actionResultFragmentToCalculatorFragment3()
                this.findNavController()?.navigate(action)
                viewModel.navigationDone()
            }
        })
    }
}
package com.example.bmi_app.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bmi_app.R
import com.example.bmi_app.databinding.FragmentCalculatorBinding

class CalculatorFragment: Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculator, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}

data class BMI(val bmi: Double, val tip: String, val color: Int){}
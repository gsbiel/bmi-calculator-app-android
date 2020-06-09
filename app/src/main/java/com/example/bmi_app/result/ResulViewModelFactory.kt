package com.example.bmi_app.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bmi_app.calculator.BMI
import java.lang.IllegalArgumentException

class ResultViewModelFactory(
        private val bmiData: BMI
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ResultViewModel::class.java)){
            return ResultViewModel(bmiData) as T
        }
        throw IllegalArgumentException("Unknown view model class.")
    }
}
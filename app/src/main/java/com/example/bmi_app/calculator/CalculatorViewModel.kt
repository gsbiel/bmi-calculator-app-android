package com.example.bmi_app.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    private val _navigateToResultFragment = MutableLiveData<Boolean>()
    val navigateToResultFragment: LiveData<Boolean>
        get() = _navigateToResultFragment

    fun navigationToResultFragmentCompleted() {
        _navigateToResultFragment.value = false
    }

    fun calculateBMI() {
        _navigateToResultFragment.value = true
    }
}
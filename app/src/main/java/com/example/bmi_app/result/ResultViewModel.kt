package com.example.bmi_app.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel: ViewModel(){

    private val _navigateToCalculatorFragment = MutableLiveData<Boolean>()
    val navigateToCalculatorFragment: LiveData<Boolean>
        get() = _navigateToCalculatorFragment

    init{
        _navigateToCalculatorFragment.value = false
    }

    fun navigateBack(){
        _navigateToCalculatorFragment.value = true
    }

    fun navigationDone(){
        _navigateToCalculatorFragment.value = false
    }
}
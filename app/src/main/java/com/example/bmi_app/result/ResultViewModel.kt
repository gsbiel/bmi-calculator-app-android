package com.example.bmi_app.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bmi_app.calculator.BMI

class ResultViewModel(bmiData: BMI): ViewModel(){

    private val _bmiDataState = MutableLiveData<BMI>()
    val bmiDataState:LiveData<BMI>
        get() = _bmiDataState

    val bmiText = Transformations.map(bmiDataState){
        "%.2f".format(it.bmi)
    }

    val tip = Transformations.map(bmiDataState){
        it.tip
    }

    val color = Transformations.map(bmiDataState){
        it.color
    }

    private val _navigateToCalculatorFragment = MutableLiveData<Boolean>()
    val navigateToCalculatorFragment: LiveData<Boolean>
        get() = _navigateToCalculatorFragment

    init{
        _navigateToCalculatorFragment.value = false
        _bmiDataState.value = bmiData
        Log.i("ResultViewModel","Iniciando Fragment com dados: $bmiData")
    }

    fun navigateBack(){
        _navigateToCalculatorFragment.value = true
    }

    fun navigationDone(){
        _navigateToCalculatorFragment.value = false
    }
}
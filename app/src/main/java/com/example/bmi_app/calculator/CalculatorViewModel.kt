package com.example.bmi_app.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    companion object{
        private const val MAX_HEIGHT: Double = 3.0  // m
        private const val MAX_WEIGHT: Double = 500.0 // Kg
    }

    private val _height = MutableLiveData<Int>()
    val height: LiveData<Int>
        get() = _height

    val heightString = Transformations.map(_height){
        "%.2f m".format(MAX_HEIGHT*it/100.0)
    }

    private val _weight = MutableLiveData<Int>()
    val weight: LiveData<Int>
        get() = _weight

    val weightString = Transformations.map(_weight){
        "%.1f kg".format(MAX_WEIGHT*it/100.0)
    }

    private val _navigateToResultFragment = MutableLiveData<Boolean>()
    val navigateToResultFragment: LiveData<Boolean>
        get() = _navigateToResultFragment

    init{
        _navigateToResultFragment.value = false
        _height.value = 50
        _weight.value = 50
    }

    fun navigationDone() {
        _navigateToResultFragment.value = false
    }

    fun calculateBMI() {
        _navigateToResultFragment.value = true
    }

    fun onHeightChangedHandler(value:Int){
        _height.value = value
    }

    fun onWeightChangedHandler(value: Int){
        _weight.value = value
    }
}

data class BMI(val bmi: Double, val tip: String, val color: Int){}
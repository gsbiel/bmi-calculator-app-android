package com.example.bmi_app.calculator

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bmi_app.R
import kotlinx.android.parcel.Parcelize

class CalculatorViewModel: ViewModel() {

    companion object{
        private const val MAX_HEIGHT: Double = 3.0  // m
        private const val MAX_WEIGHT: Double = 500.0 // Kg
    }

    // --------------------------------------------------------------------------------------------
    // Height related data ------------------------------------------------------------------------

    private val _height = MutableLiveData<Int>()
    val height: LiveData<Int>
        get() = _height

    val heightString = Transformations.map(_height){
        "%.2f m".format(MAX_HEIGHT*it/100.0)
    }

    val heightMeasured: Double
        get() = (height.value!!.times(MAX_HEIGHT))/100.0

    // --------------------------------------------------------------------------------------------
    // Weight related data ------------------------------------------------------------------------

    private val _weight = MutableLiveData<Int>()
    val weight: LiveData<Int>
        get() = _weight

    val weightString = Transformations.map(_weight){
        "%.1f kg".format(MAX_WEIGHT*it/100.0)
    }

    val weightMeasured: Double
        get() = (weight.value!!.times(MAX_WEIGHT))/100.0

    // --------------------------------------------------------------------------------------------
    // Navigation related data --------------------------------------------------------------------

    private val _navigateToResultFragment = MutableLiveData<BMI>()
    val navigateToResultFragment: LiveData<BMI>
        get() = _navigateToResultFragment

    // --------------------------------------------------------------------------------------------

    init{
        _navigateToResultFragment.value = null
        _height.value = 50
        _weight.value = 50
    }

    fun navigationDone() {
        _navigateToResultFragment.value = null
    }

    fun calculateBMI() {
        val calculatedBmi: Double = getBmi(weightMeasured, heightMeasured)
        val tip: String = getTipForValue(calculatedBmi)
        val color = getColorForValue(calculatedBmi)
        _navigateToResultFragment.value = BMI(calculatedBmi,tip,color)
    }

    private fun getBmi(weight: Double, height: Double): Double{
        return (weight/(height*height))
    }

    private fun getTipForValue(bmi: Double): String{
        if (bmi < 18.5) {
            return "Eat more pies! :(";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Fit as a fiddle! :D";
        } else {
            return "Eat less pies! :o";
        }
    }

    private fun getColorForValue(bmi: Double):Int{
        if (bmi < 18.5) {
            return R.color.badBmi
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return R.color.goodBmi
        } else {
            return R.color.acceptableBmi
        }
    }

    fun onHeightChangedHandler(value:Int){
        _height.value = value
    }

    fun onWeightChangedHandler(value: Int){
        _weight.value = value
    }
}

@Parcelize
data class BMI(val bmi: Double, val tip: String, val color: Int):Parcelable
package com.example.bmi_app

import android.os.Bundle
import android.view.View
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val maxHeight = 3.0
    private val maxWeight = 250.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val BMI_VALUE_KEY = "com.bmiapp.bmivaluekey"
        const val BMI_TIP_KEY = "com.bmiapp.bmitipkey"
        const val BMI_COLOR_KEY = "com.bmiapp.bmiColorKey"
    }
}
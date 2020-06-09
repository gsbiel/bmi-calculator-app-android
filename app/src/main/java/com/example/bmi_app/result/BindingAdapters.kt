package com.example.bmi_app.result

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("liveColor")
fun TextView.setColor(color: Int){
    setTextColor(color)
}
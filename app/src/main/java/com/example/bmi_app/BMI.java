package com.example.bmi_app;

import android.graphics.Color;

public class BMI {

    private double bmi;
    private String tip;
    private int color;

    BMI(double bmi_value){
        this.bmi = bmi_value;
        if (bmi_value < 18.5) {
            this.tip = "Eat more pies! :(";
            this.color = Color.rgb(255,0,0);
        } else if (bmi_value >= 18.5 && bmi_value <= 24.9) {
            this.tip = "Fit as a fiddle! :D";
            this.color = Color.rgb(0,0,255);
        } else {
            this.tip = "Eat less pies! :o";
            this.color = Color.rgb(255,0,0);
        }
    }

    public double getBMI(){
        return this.bmi;
    }

    public String getTip(){
        return this.tip;
    }

    public int getColor(){
        return this.color;
    }
}

package com.example.bmi_app;

public class BMI {

    private double bmi;
    private String tip;
    private String color;

    BMI(double bmi_value){
        this.bmi = bmi_value;
        if (bmi_value < 18.5) {
            this.tip = "Eat more pies! :(";
            this.color = "#000";
        } else if (bmi_value >= 18.5 && bmi_value <= 24.9) {
            this.tip = "Fit as a fiddle! :D";
            this.color = "#000";
        } else {
            this.tip = "Eat less pies! :o";
            this.color = "#000";
        }
    }

    public double getBMI(){
        return this.bmi;
    }

    public String getTip(){
        return this.tip;
    }

    public String getColor(){
        return this.color;
    }
}

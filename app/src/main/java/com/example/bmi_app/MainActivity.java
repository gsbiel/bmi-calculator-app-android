package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Button calculateBtn;
    private TextView heightLabel;
    private TextView weightLabel;
    private SeekBar heightSeekbar;
    private SeekBar weightSeekbar;

    private double maxHeight = 3.0;
    private double maxWeight = 250.0;

    private double currentHeigh;
    private double currentWeight;
    private BMI bmiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.catchReferencesForUIElements();
        this.registerForUIEvents();
        this.updateUI();
    }

    private void catchReferencesForUIElements(){
        this.calculateBtn = findViewById(R.id.calculateButton);
        this.heightLabel = findViewById(R.id.heightLabel);
        this.weightLabel = findViewById(R.id.weightLabel);
        this.heightSeekbar = findViewById(R.id.heightSeekbar);
        this.weightSeekbar = findViewById(R.id.weightSeekbar);
    }

    private void registerForUIEvents(){
        this.calculateBtn.setOnClickListener(this);
        this.heightSeekbar.setOnSeekBarChangeListener(this);
        this.weightSeekbar.setOnSeekBarChangeListener(this);
    }

    private void updateUI(){

        this.currentHeigh = this.heightSeekbar.getProgress()*this.maxHeight/100;
        this.currentWeight = this.weightSeekbar.getProgress()*this.maxWeight/100;

        this.heightLabel.setText(Double.toString(this.currentHeigh) + " m");
        this.weightLabel.setText(Double.toString(this.currentWeight) + " kg");

        double bmi_value = this.currentWeight / (this.currentHeigh*this.currentHeigh);
        this.bmiData = new BMI(bmi_value);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){

            case R.id.calculateButton:
                System.out.println("Button pressed!");
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.updateUI();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

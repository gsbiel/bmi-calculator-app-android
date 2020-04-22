package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.catchReferencesForUIElements();
        this.registerForUIEvents();
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
        this.heightLabel.setText(Double.toString((this.heightSeekbar.getProgress()*this.maxHeight)/100) + " m");
        this.weightLabel.setText(Double.toString((this.weightSeekbar.getProgress()*this.maxWeight)/100) + " kg");
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){

            case R.id.calculateButton:
                System.out.println("Button pressed!");

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

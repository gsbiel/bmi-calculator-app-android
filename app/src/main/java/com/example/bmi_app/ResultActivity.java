package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private static DecimalFormat df = new DecimalFormat("0.00");

    private TextView bmiLabel;
    private TextView tipLabel;
    private Button recalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.catchReferencesForUIElements();
        this.registerForUIEvents();
        this.updateUI();
    }

    private void catchReferencesForUIElements(){
        this.bmiLabel = findViewById(R.id.bmiLabel);
        this.tipLabel = findViewById(R.id.tipLabel);
        this.recalculateButton = findViewById(R.id.recalculateBtn);
    }

    private void registerForUIEvents(){
        this.recalculateButton.setOnClickListener(this);
    }

    private void updateUI(){
        Bundle intentExtras = getIntent().getExtras();
        double bmiValue = intentExtras.getDouble(MainActivity.bmiValueKey);
        int bmiColor = intentExtras.getInt(MainActivity.bmiColorKey);
        String bmiTip = intentExtras.getString(MainActivity.bmiTipKey);
        System.out.println(bmiValue + " " + bmiTip + " " + bmiColor);
        this.bmiLabel.setText(df.format(bmiValue));
        this.tipLabel.setText(bmiTip);
        this.bmiLabel.setTextColor(bmiColor);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.recalculateBtn){
            System.out.println("Go back to previous screen!");
            finish();
        }
    }
}

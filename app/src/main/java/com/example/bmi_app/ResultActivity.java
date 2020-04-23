package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView bmiLabel;
    private TextView tipLabel;
    private Button recalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.catchReferencesForUIElements();
        this.registerForUIEvents();
    }

    private void catchReferencesForUIElements(){
        this.bmiLabel = findViewById(R.id.bmiLabel);
        this.tipLabel = findViewById(R.id.tipLabel);
        this.recalculateButton = findViewById(R.id.recalculateBtn);
    }

    private void registerForUIEvents(){
        this.recalculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.recalculateBtn){
            System.out.println("Go back to previous screen!");
            finish();
        }
    }
}

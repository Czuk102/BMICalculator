package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText heightField = findViewById(R.id.height);
        EditText weightField = findViewById(R.id.weight);
        Button calculateBtn = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(heightField.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(weightField.getText()));
                float bmi = calculateBMI(height, weight);
                result.setText(String.valueOf(bmi));
            }
        });
    }
    private float calculateBMI (float height, float weight){
        return weight / (height * height);
    }
}
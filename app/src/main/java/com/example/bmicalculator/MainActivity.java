package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    Map<Float,String> bmiLabels = new TreeMap<>();

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeBMILabels();
        EditText heightField = findViewById(R.id.height);
        EditText weightField = findViewById(R.id.weight);
        Button calculateBtn = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);
        TextView label = findViewById(R.id.label);
        calculateBtn.setOnClickListener(v -> {
            float height = Float.parseFloat(String.valueOf(heightField.getText())) / 100;
            float weight = Float.parseFloat(String.valueOf(weightField.getText()));
            float bmi = calculateBMI(height, weight);
            label.setText(getBMILabel(bmi));
            result.setText(String.format("%.2f", bmi));
        });
    }
    private float calculateBMI (float height, float weight){
        return weight / (height * height);
    }
    private void initializeBMILabels() {
        bmiLabels.put(16.0f, "wygłodzenie");
        bmiLabels.put(16.99f, "wychudzenie");
        bmiLabels.put(18.49f, "niedowaga");
        bmiLabels.put(24.99f, "wartość prawidłowa");
        bmiLabels.put(29.99f, "nadwaga");
        bmiLabels.put(34.99f, "otyłość I stopnia");
        bmiLabels.put(39.99f, "otyłość II stopnia");
        bmiLabels.put(Float.MAX_VALUE, "otyłość III stopnia");
    }

    public String getBMILabel(double bmi) {
        for (Map.Entry<Float, String> entry : bmiLabels.entrySet()) {
            if (bmi <= entry.getKey()) {
                return entry.getValue();
            }
        }
        return "";
    }
}
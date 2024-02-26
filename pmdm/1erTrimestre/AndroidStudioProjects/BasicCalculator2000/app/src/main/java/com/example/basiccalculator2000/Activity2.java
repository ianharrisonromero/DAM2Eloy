package com.example.basiccalculator2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvResult;
    final static double DEFAULT_VALUE = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvResult = findViewById(R.id.tvResultado);
        double resultado;

        Intent intent = getIntent();
        resultado = intent.getDoubleExtra(MainActivity.INFO_RESULTADO, DEFAULT_VALUE);

        tvResult.setText(String.valueOf(resultado));
    }
}
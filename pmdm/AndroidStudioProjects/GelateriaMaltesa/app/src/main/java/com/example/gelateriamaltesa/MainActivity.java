package com.example.gelateriamaltesa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etCBalls, etVBalls, etSBalls;
    TextView tvTitle, tvStrawberry, tvVanilla, tvChocolate;
    Spinner spType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
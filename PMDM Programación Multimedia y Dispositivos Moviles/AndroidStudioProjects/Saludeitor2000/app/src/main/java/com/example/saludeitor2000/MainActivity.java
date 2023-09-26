package com.example.saludeitor2000;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btSaluda;
    TextView tvOut;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSaluda = findViewById(R.id.btSaluda);
        tvOut = findViewById(R.id.tvOut);
        etInput = findViewById(R.id.etInput);

        btSaluda.setOnClickListener((View v)->{
            //magia
            String nombre = etInput.getText().toString();
            if (nombre.equals("")){
                tvOut.setText("Hola mundo!");
            } else if (nombre=="mundo"){
                tvOut.setText("Explota!");
            } else {
                tvOut.setText("Hola " + nombre);
            }
        });

    }
}
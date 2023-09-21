package com.example.saludeitor2000;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btSaluda;
    TextView tvOut;

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSaluda = findViewById(R.id.btSaluda);
        tvOut = findViewById(R.id.tvOut);
        etName = findViewById(R.id.tvOut);

        btSaluda.setOnClickListener((View v)->{
            //magia
            String nombre = etName.getText().toString();
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
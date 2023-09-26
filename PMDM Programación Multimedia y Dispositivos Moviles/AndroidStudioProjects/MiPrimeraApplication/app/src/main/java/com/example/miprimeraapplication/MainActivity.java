package com.example.miprimeraapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    Button btHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //programita para dar a un botón y que vaya concatenando un String

        tvOut = findViewById(R.id.tvOut);
        btHello = findViewById(R.id.btHello);

        btHello.setOnClickListener( (View v) -> {
            String estadoActual = tvOut.getText().toString();
            estadoActual += getResources().getString(R.string.mensaje);
            tvOut.setText(estadoActual);

            //otra opcion (con append)
            //tv.append();
            //tv.setText(R.string.mensaje);
        });

    }

}
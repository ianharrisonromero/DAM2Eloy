package com.example.miprimeraapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //programita para dar a un botón y que vaya concatenando un String

        tv = findViewById(R.id.idtvut01Salida);
        bt = findViewById(R.id.idbtut01Accion);

        bt.setOnClickListener( (View v) -> {
            String estadoActual = tv.getText().toString();
            estadoActual += getResources().getString(R.string.mensaje);
            tv.setText(estadoActual);

            //otra opcion (con append)
            //tv.append();
            //tv.setText(R.string.mensaje);
        });

    }

}
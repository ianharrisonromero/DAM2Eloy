package com.example.ejercicio1;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    Button buttonVolver, buttonReiniciar;
    TextView textViewOrigen, textViewDestino, textViewGuion, textViewSoloIda, textViewTitleIda,
            textViewTitleVuelta, textViewFechaIda, textViewFechaVuelta;
    Viaje viaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        buttonVolver = findViewById(R.id.buttonVolver);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);
        textViewOrigen = findViewById(R.id.textViewOrigen);
        textViewDestino = findViewById(R.id.textViewDestino);
        textViewGuion = findViewById(R.id.textViewGuion);
        textViewSoloIda = findViewById(R.id.textViewSoloIda);
        textViewTitleIda = findViewById(R.id.textViewTitleIda);
        textViewTitleVuelta = findViewById(R.id.textViewTitleVuelta);
        textViewFechaIda = findViewById(R.id.textViewFechaIda);
        textViewFechaVuelta = findViewById(R.id.textViewFechaVuelta);

        textViewSoloIda.setVisibility(View.GONE);
        textViewTitleVuelta.setVisibility(View.GONE);


        Intent intent = getIntent();
        viaje = (Viaje) intent.getSerializableExtra(MainActivityEj1.INFO_VIAJE);

        textViewOrigen.setText(viaje.getOrigen().toString());
        textViewDestino.setText(viaje.getDestino().toString());
        textViewFechaIda.setText(viaje.getFechaIda().toString());
        textViewTitleVuelta.setVisibility(View.VISIBLE);
        textViewFechaVuelta.setText(viaje.getFechaVuelta().toString());

        if(viaje.isSoloIda()){
            textViewSoloIda.setVisibility(View.VISIBLE);

        }

        buttonReiniciar.setOnClickListener(v -> {
            Intent intent2 = new Intent();
            setResult(RESULT_OK, intent2);
            finish();
        });

        buttonVolver.setOnClickListener(v -> {
            finish();
        });





        //
    }
}
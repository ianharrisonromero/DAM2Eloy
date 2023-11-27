package com.example.pmdm_2324.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut04a1_Holamundo extends AppCompatActivity {

    ImageView estrella;
    ut04f1_Holamundo fragment;
    TextView color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut04a1_holamundo);

        estrella = findViewById(R.id.u4a1idiestrella);
        color = findViewById(R.id.u4a1idtvcolor);

        // getFragmentManager().getFragments() // Esto devuelve list
        fragment = (ut04f1_Holamundo) getSupportFragmentManager().findFragmentById(R.id.u4a1idf1);

        estrella.setOnClickListener((View) -> {
            fragment.setColor(0x77, 0xFF, 00, 0xFF);
            fragment.setText("Truco de magia con esta cadena mágica");
        });

        fragment.setColorChangeListener(
                new ICambioColor() {
                    @Override
                    public void OnColorChange(int c) {
                        color.setText("Funciona asqueroso" + String.valueOf(c));
                    }
                }
        // (int c)-> color.setText("Funciona asqueroso" + String.valueOf(c))
        );
    }
}

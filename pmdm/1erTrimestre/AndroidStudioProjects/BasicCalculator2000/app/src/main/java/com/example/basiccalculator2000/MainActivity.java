package com.example.basiccalculator2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitulo, tvOperador1, tvOperador2, tvOperacion, tvAlertaRg, tvAlertaDivision;
    EditText etOperador1, etOperador2;
    RadioGroup rgOperaciones;
    RadioButton rbSuma, rbResta, rbMultiplicacion, rbDivision;
    Button btCalcular;
    static final String INFO_RESULTADO = "com.example.basiccalculator2000";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvOperacion = findViewById(R.id.tvOperacion);
        tvOperador1 = findViewById(R.id.tvOperador1);
        tvOperador2 = findViewById(R.id.tvOperador2);
        tvAlertaRg = findViewById(R.id.tvAlertaRg);
        tvAlertaDivision = findViewById(R.id.tvAlertaDivision);
        etOperador1 = findViewById(R.id.etOperador1);
        etOperador2 = findViewById(R.id.etOperador2);
        rgOperaciones = findViewById(R.id.rgOperaciones);
        rbDivision = findViewById(R.id.rbDivision);
        rbMultiplicacion = findViewById(R.id.rbMultiplicacion);
        rbResta = findViewById(R.id.rbResta);
        rbSuma = findViewById(R.id.rbSuma);
        btCalcular = findViewById(R.id.btCalcular);

        tvAlertaRg.setVisibility(View.GONE);
        tvAlertaDivision.setVisibility(View.GONE);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double operandof1=0, operandof2=0, resultado=0;
                operandof1 = Double.parseDouble(etOperador1.getText().toString());
                operandof2 = Double.parseDouble(etOperador2.getText().toString());
                tvAlertaRg.setVisibility(View.GONE);
                tvAlertaDivision.setVisibility(View.GONE);

                if (rgOperaciones.getCheckedRadioButtonId() == -1){
                    tvAlertaRg.setVisibility(View.VISIBLE);
                } else {
                    int checkedRadioButtonId = rgOperaciones.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);

                    if (selectedRadioButton == rbDivision) {
                        if (operandof2 == 0) {
                            tvAlertaDivision.setVisibility(View.VISIBLE);
                        } else {
                            resultado = operandof1 / operandof2;
                        }
                    } else if (selectedRadioButton == rbMultiplicacion) {
                        resultado = operandof1 * operandof2;
                    } else if (selectedRadioButton == rbResta) {
                        resultado = operandof1 - operandof2;
                    } else if (selectedRadioButton == rbSuma) {
                        resultado = operandof1 + operandof2;
                    }

                    if (tvAlertaDivision.getVisibility() != View.VISIBLE) {

                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        intent.putExtra(INFO_RESULTADO, resultado);
                        startActivity(intent);
                    }

                }

            }
        });


    }//oncreate
}//main
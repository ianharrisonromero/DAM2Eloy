package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextFiboActivity extends AppCompatActivity {

    TextView tvNextNum;
    Button btOk;
    public static final String N_SUM = "NextFiboActivity.N_SUM";
    int num1, num2 , num_sum;
    String numSumString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_fibo);
        tvNextNum = findViewById(R.id.tvNextNum);
        btOk = findViewById(R.id.btOk);


        Intent intent = getIntent();
        num1 = Integer.parseInt(intent.getStringExtra(MainActivity.N1));
        num2 = Integer.parseInt(intent.getStringExtra(MainActivity.N2));
        num_sum = num1+num2;
        numSumString = String.valueOf(num_sum);
        tvNextNum.setText(numSumString);

        btOk.setOnClickListener(view -> {
            Intent data = new Intent(this, MainActivity.class);
            setResult(Activity.RESULT_OK);
            data.putExtra(N_SUM, numSumString);
            finish();
        });



    }
}
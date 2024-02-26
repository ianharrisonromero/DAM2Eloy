package com.example.fibonacci;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvFibo1, tvFibo2, tvNum1, tvNum2;
    Button btNext;
    public static final String N1 = "MainActivity.N1", N2="MainActivity.N2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvFibo1 = findViewById(R.id.tvFibo1);
        tvFibo2 = findViewById(R.id.tvFibo2);
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        btNext = findViewById(R.id.btNext);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        tvNum1.setText(tvNum2.getText().toString());
                        String nSum = data.getStringExtra(NextFiboActivity.N_SUM);
                        tvNum2.setText(nSum);

                    }else{
                        tvTitle.setText("Cant reach code");
                        }
                    }
        );

        btNext.setOnClickListener(view -> {

            Intent intent = new Intent(this, NextFiboActivity.class);
            intent.putExtra(N1, tvNum1.getText().toString());
            intent.putExtra(N2, tvNum2.getText().toString());
            launcher.launch(intent);
        });

    }
}
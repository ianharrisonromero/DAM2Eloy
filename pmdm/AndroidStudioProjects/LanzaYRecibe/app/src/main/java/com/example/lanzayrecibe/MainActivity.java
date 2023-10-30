package com.example.lanzayrecibe;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btObtainNumber;
    TextView tvNumTitle, tvNumber, tvSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btObtainNumber = findViewById(R.id.btObtainNumber);
        tvNumber = findViewById(R.id.tvNumber);
        tvSMS = findViewById(R.id.tvSMS);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            tvNumber.setText(data.getStringExtra(ObtainNumberActivity.NUMBER_KEY));
                            tvNumber.setTextColor(0xFF33CC33); //another green
                            int num = Integer.parseInt(tvNumber.getText().toString());
                            if(isPrime(num)){
                                tvSMS.setText("The number " + num +" is prime");
                                tvSMS.setTextColor(0xFF33CC33); //green
                            } else {
                                tvSMS.setText("The number " + num +" is not prime");
                                tvSMS.setTextColor(Color.DKGRAY);
                                tvNumber.setTextColor(Color.DKGRAY);
                            }
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                            tvSMS.setText("The user cancelled the operation");
                            tvNumber.setText("- -");
                            tvSMS.setTextColor(Color.RED);
                        } else {
                            tvSMS.setText("Cant reach code");
                            tvSMS.setTextColor(Color.RED);
                        }
                    }
                }
        );

        btObtainNumber.setOnClickListener(view -> {
            Intent i = new Intent(this, ObtainNumberActivity.class);
            launcher.launch(i);
        });

        }
    public boolean isPrime (int num) {
        boolean isPrime = true;
        if (num == 0 || num == 1) {
            isPrime=false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num%i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;

    }
}
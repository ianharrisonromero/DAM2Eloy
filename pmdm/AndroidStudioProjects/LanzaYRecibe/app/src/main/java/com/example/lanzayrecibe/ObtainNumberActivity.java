package com.example.lanzayrecibe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ObtainNumberActivity extends AppCompatActivity {

    public static final String NUMBER_KEY = "0";

    TextView tvTitle;
    EditText etNumber;
    Button btAccept, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtain_number);

        tvTitle = findViewById(R.id.tvTitle);
        etNumber = findViewById(R.id.etNumber);
        btAccept = findViewById(R.id.btAccept);
        btCancel = findViewById(R.id.btCancel);

        btAccept.setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra(NUMBER_KEY, etNumber.getText().toString());
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        btCancel.setOnClickListener(v -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });


    }
}
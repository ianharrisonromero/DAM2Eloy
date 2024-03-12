package com.example.piramideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

        tv.setOnClickListener(v -> {
            tv.setText(printPyramid(et.getText().toString()));
        });
    }

    private String printPyramid(String num) {
        int height = Integer.parseInt(num);
        String pyramid= "";

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++) {
                pyramid += "*";
            }
            pyramid += "\n";
        }
        return pyramid;
    }

}
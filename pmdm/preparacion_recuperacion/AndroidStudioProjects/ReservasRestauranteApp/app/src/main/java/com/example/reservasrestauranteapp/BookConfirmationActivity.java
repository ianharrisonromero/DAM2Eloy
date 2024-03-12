package com.example.reservasrestauranteapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.reservasrestauranteapp.databinding.ActivityBookConfirmationBinding;

import java.io.Serializable;

public class BookConfirmationActivity extends AppCompatActivity implements Serializable {

    TextView tvMostrar;
    Button buttonVolver, buttonReiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_confirmation);

        tvMostrar = findViewById(R.id.tvMostrar);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);
        buttonVolver = findViewById(R.id.buttonVolver);

        Intent intent = getIntent();

        Book newBook = (Book) intent.getSerializableExtra(MainActivity.BOOK_INFO);

        tvMostrar.setText(newBook.toString());

        buttonVolver.setOnClickListener(v -> {
            setResult(BookConfirmationActivity.RESULT_CANCELED);
            finish();
        });

        buttonReiniciar.setOnClickListener(v -> {
            setResult(BookConfirmationActivity.RESULT_OK);
            finish();
        });

    }
}
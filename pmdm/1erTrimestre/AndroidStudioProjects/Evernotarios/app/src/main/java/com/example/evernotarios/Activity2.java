package com.example.evernotarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity  {

    TextView textViewDisplay;
    Button buttonBack;
    NoteBook noteBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewDisplay = findViewById(R.id.textViewDisplay);
        buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        noteBook = (NoteBook) intent.getSerializableExtra(MainActivity.NOTE_DATA);

        textViewDisplay.setText(noteBook.toString());

        buttonBack.setOnClickListener(view -> {
            Intent intent2 = new Intent();
            intent2.putExtra(MainActivity.NOTE_DATA, noteBook);
            setResult(RESULT_CANCELED, intent2);
            finish();
        });

    }
}
package com.example.calendar_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvPicked;
    Button buttonDate, buttonTime;
    Calendar myDate, myTime;
    boolean datePicked;

    LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPicked = findViewById(R.id.tvPicked);
        buttonDate = findViewById(R.id.buttonDate);
        buttonTime = findViewById(R.id.buttonTime);
        myDate = Calendar.getInstance();
        myTime = Calendar.getInstance();

        buttonDate.setOnClickListener( view -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    try {
                        myDate.set(year, month, day);
                    } catch (Exception e){}

                    datePicked = true;

                }
            }, year, month, day);
            datePickerDialog.show();
        });

        try {
            selectedDate = LocalDate.of(myDate.get(Calendar.YEAR), myDate.get(Calendar.MONTH), myDate.get(Calendar.DAY_OF_MONTH));

        } catch (Exception e){}

        try {
            tvPicked.setText(selectedDate.toString());
        } catch (Exception e){}





    }
}
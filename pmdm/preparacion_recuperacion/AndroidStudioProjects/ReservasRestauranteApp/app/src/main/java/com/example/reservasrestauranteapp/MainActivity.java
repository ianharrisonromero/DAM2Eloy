package com.example.reservasrestauranteapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private static final String MAKE_SELECTION_MSG = "Select both day and time for the book";
    private static final String RESTAURANT_CLOSED_ERROR = "Restaurant is closed at this time";
    static final String BOOK_INFO = "BOOK_INFO";
    static final long ONE_HOUR = 3600000;
    Button buttonDay, buttonTime, buttonBook;
    TextView tvDay, tvTime, tvError;
    EditText etGuests;
    Integer guestsNum = null;
    public static Calendar selectedDay = null, selectedTime = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBook = findViewById(R.id.buttonBook);
        buttonDay = findViewById(R.id.buttonDay);
        buttonTime = findViewById(R.id.buttonTime);
        tvDay = findViewById(R.id.tvDay);
        tvTime = findViewById(R.id.tvTime);
        tvError = findViewById(R.id.tvError);
        etGuests = findViewById(R.id.etGuests);



        buttonDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new MyCustomDayDialog();
                timePicker.show(getSupportFragmentManager(), "date Picker");
            }
        });

        buttonTime.setOnClickListener( (view) -> {
            DialogFragment timePicker = new MyCustomTimeDialog();
            timePicker.show(getSupportFragmentManager(), "time picker");
        });

//        etGuests.setOnClickListener( v -> {
//            etGuests.setText("");
//        });

        buttonBook.setOnClickListener(v -> {

            guestsNum = Integer.parseInt(etGuests.getText().toString());
            if (selectedTime != null && selectedDay != null && guestsNum != null) {
                Intent intent = new Intent(MainActivity.this, BookConfirmationActivity.class);
                Book newBook = new Book(selectedDay, selectedTime, guestsNum);
                intent.putExtra(BOOK_INFO, newBook);
                launcher.launch(intent);

            } else {
                tvError.setText(MAKE_SELECTION_MSG);
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        selectedDay = Calendar.getInstance();
        selectedDay.set(Calendar.YEAR, year);
        selectedDay.set(Calendar.MONTH, month);
        selectedDay.set(Calendar.DAY_OF_MONTH, day);

        if (selectedDay.getTimeInMillis() >= System.currentTimeMillis() + ONE_HOUR){
            String currentDateString = DateFormat.getDateInstance().format(selectedDay.getTime());
            tvDay.setText(currentDateString);
        } else {
            selectedDay = null;
            tvError.setText("BOOK HAS TO BE AT LEAST IN ONE HOUR FROM NOW");
            return;
        }


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        selectedTime = Calendar.getInstance();
        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        selectedTime.set(Calendar.MINUTE, minute);

        if (hourOfDay < 11 || hourOfDay > 23){
            tvError.setText(RESTAURANT_CLOSED_ERROR);
            selectedTime = null;
            return;
        }

        tvTime.setText(hourOfDay + ":" + minute);

    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == BookConfirmationActivity.RESULT_OK){ //REINICIAR
                reiniciarCampos();
            } else if (result.getResultCode() == BookConfirmationActivity.RESULT_CANCELED){ //VOLVER
                //no hacer nada
            }
        }
    });

    private void reiniciarCampos() {
        selectedDay = Calendar.getInstance();
        selectedTime = Calendar.getInstance();
        tvTime.setText("Time");
        tvDay.setText("Day");
        etGuests.setText("Guests number");
        tvError.setText("");
    }
}
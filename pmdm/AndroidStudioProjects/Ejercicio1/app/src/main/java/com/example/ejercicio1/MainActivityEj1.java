package com.example.ejercicio1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivityEj1 extends AppCompatActivity {

    Button buttonReservar, buttonFechaIda, buttonFechaVuelta;
    TextView textViewDestino, textViewSoloIda, textViewIda, textViewVuelta;
    Spinner spinnerOrigen, spinnerDestino;
    CheckBox checkBoxSoloIda;

    static final boolean SOLO_IDA = true;
    Calendar myCalendarIda = Calendar.getInstance();
    Calendar myCalendarVuelta = Calendar.getInstance();

//    final static String INFO_ORIGEN = "MainActivity.info_origen", INFO_DESTINO = "MainActivity.info_destino",
//            INFO_DATE_IDA = "MainActivity.info_date_ida", INFO_DATE_VUELTA = "MainActivity.info_date_vuelta",
//            INFO_SOLO_IDA = "MainActivity.info_solo_ida";
    final static String INFO_VIAJE = "MainActivity.info_viaje";
    Viaje viaje;
    String myCalendarDay = "";
    String myCalendarMonth = "";
    String myCalendarYear = "";
    String dateString = "";

    final String ALERT_DIALOG_MSG = "Fecha inválida";
    final long SOME_MILLIS = 100000; // FOR TODAY




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReservar = findViewById(R.id.buttonReservar);
        buttonFechaIda = findViewById(R.id.buttonFechaIda);
        buttonFechaVuelta = findViewById(R.id.buttonFechaVuelta);
        spinnerOrigen = findViewById(R.id.spinnerOrigen);
        spinnerDestino = findViewById(R.id.spinnerDestino);
        textViewIda = findViewById(R.id.textViewIda);
        textViewVuelta = findViewById(R.id.textViewVuelta);
        checkBoxSoloIda = findViewById(R.id.checkBoxSoloIda);


        ArrayList<Ciudad> ciudadesList = new ArrayList<>();


        for(Ciudad ciudad : Ciudad.values()){
            ciudadesList.add(ciudad);
        }

        ArrayAdapter<Ciudad> adapterContainer = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, ciudadesList);
        spinnerOrigen.setAdapter(adapterContainer);

        ArrayAdapter<Ciudad> adapterContainer2 = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, ciudadesList);
        spinnerDestino.setAdapter(adapterContainer2);





        buttonFechaIda.setOnClickListener(view -> {
            // on below line we are getting the instance of our calendar.
            final Calendar myDate = Calendar.getInstance();

            // on below line we are getting our day, month and year.
            int year = myDate.get(Calendar.YEAR);
            int month = myDate.get(Calendar.MONTH);
            int day = myDate.get(Calendar.DAY_OF_MONTH);

            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    MainActivityEj1.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            try {
                                myCalendarIda.set(year, monthOfYear, dayOfMonth);  //pasamos los valores a variable externa (myCalendar)
                                myCalendarDay = myCalendarIda.getTime().toString().substring(8,10);
                                myCalendarMonth = myCalendarIda.getTime().toString().substring(4,7);
                                myCalendarYear = myCalendarIda.getTime().toString().substring(30,34);
                                dateString = myCalendarDay + "/" + myCalendarMonth + "/" +myCalendarYear ;
                                textViewIda.setText(dateString);

                            } catch (Exception e){

                            }
                        }
                    },
                    // on below line we are passing year,
                    // month and day for selected date in our date picker.
                    year, month, day);
            // at last we are calling show to
            // display our date picker dialog.
            datePickerDialog.show();
        });

        buttonFechaVuelta.setOnClickListener(view -> {
            // on below line we are getting the instance of our calendar.
            final Calendar myDate = Calendar.getInstance();

            // on below line we are getting our day, month and year.
            int year = myDate.get(Calendar.YEAR);
            int month = myDate.get(Calendar.MONTH);
            int day = myDate.get(Calendar.DAY_OF_MONTH);

            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    MainActivityEj1.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            try {
                                myCalendarVuelta.set(year, monthOfYear, dayOfMonth);  //pasamos los valores a variable externa (myCalendar)
                                myCalendarDay = myCalendarVuelta.getTime().toString().substring(8,10);
                                myCalendarMonth = myCalendarVuelta.getTime().toString().substring(4,7);
                                myCalendarYear = myCalendarVuelta.getTime().toString().substring(30,34);
                                dateString = myCalendarDay + "/" + myCalendarMonth + "/" +myCalendarYear ;
                                textViewVuelta.setText(dateString);

                            } catch (Exception e){

                            }
                        }
                    },
                    // on below line we are passing year,
                    // month and day for selected date in our date picker.
                    year, month, day);
            // at last we are calling show to
            // display our date picker dialog.
            datePickerDialog.show();
        });

        checkBoxSoloIda.setOnClickListener(view -> {
            if (checkBoxSoloIda.isChecked()){
                spinnerDestino.setEnabled(false);
            } else {
                spinnerDestino.setEnabled(true);
            }

        });

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity2.RESULT_OK){
                    try {
                        textViewDestino.setText("");
                        textViewIda.setText("");
                        textViewSoloIda.setText("");
                        checkBoxSoloIda.setActivated(false);
                    } catch (Exception e){}

                } else if (result.getResultCode() == Activity2.RESULT_CANCELED){
                } else {
                    //otro error
                }

            }
        });

        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myCalendarIda.getTimeInMillis() > myCalendarVuelta.getTimeInMillis() ||
                        myCalendarIda.getTimeInMillis() < Calendar.getInstance().getTimeInMillis() + SOME_MILLIS){
                    showDateAlert();

                } else if (spinnerDestino.getSelectedItem().toString().equals(spinnerOrigen.getSelectedItem().toString())) {
                    showCityAlert();

                } else {

                    if (checkBoxSoloIda.isChecked()) {
                        Viaje viaje = new Viaje(spinnerOrigen.getSelectedItem().toString(), textViewIda.getText().toString(), SOLO_IDA);
                        Intent intent = new Intent(MainActivityEj1.this, Activity2.class);
                        intent.putExtra(INFO_VIAJE, viaje);
                        launcher.launch(intent);

                    } else if (!checkBoxSoloIda.isChecked()) {
                        Viaje viaje = new Viaje(spinnerOrigen.getSelectedItem().toString(), spinnerDestino.getSelectedItem().toString(),
                                textViewIda.getText().toString(), textViewVuelta.getText().toString());

                        Intent intent = new Intent(MainActivityEj1.this, Activity2.class);
                        intent.putExtra(INFO_VIAJE, viaje);
                        launcher.launch(intent);
                    }
                }


//                Container selectedContainer = (Container) spinnerContainer.getSelectedItem();

            }
        });

    }
    public void showDateAlert(){
        final String ALERT_DIALOG_TITLE = getResources().getString(R.string.alert_dialog_date);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityEj1.this);
        builder.setTitle(getResources().getString(R.string.alert_dialog_title))
                .setMessage(getResources().getString(R.string.alert_null_msg))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
        ;
    }
    public void showCityAlert(){
        final String ALERT_DIALOG_TITLE = getResources().getString(R.string.alert_dialog_city);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityEj1.this);
        builder.setTitle(getResources().getString(R.string.alert_dialog_title))
                .setMessage(getResources().getString(R.string.alert_null_msg_date))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
        ;
    }
}
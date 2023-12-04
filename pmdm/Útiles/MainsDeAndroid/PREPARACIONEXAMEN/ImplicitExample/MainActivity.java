package com.rittz.implicitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String URL_OUT = "https://genius.com/Pink-floyd-wish-you-were-here-lyrics";
    private static final String DIAL_OUT = "666";
    Button buttonBrowser, buttonDial, buttonSms, buttonCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBrowser = findViewById(R.id.buttonBrowser);
        buttonDial = findViewById(R.id.buttonDial);
        buttonSms = findViewById(R.id.buttonSms);
        buttonCamera = findViewById(R.id.buttonMagic);

        //ACTION_VIEW - BROWSER
        buttonBrowser.setOnClickListener(view -> {
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_OUT));
            startActivity(implicit);
        });

        //ACTION_DIAL - DIAL A NUMBER
        buttonDial.setOnClickListener(view -> {
            Intent implicit = new Intent(Intent.ACTION_DIAL, Uri.parse(DIAL_OUT));
            if (implicit.resolveActivity(getPackageManager()) != null) {
                startActivity(implicit);
            } else {
                Toast.makeText(MainActivity.this, "Error perrol", Toast.LENGTH_LONG).show();
            }
        });

        //ACTION_SEND - SMS
        buttonSms.setOnClickListener(view -> {
            String phoneNumber = DIAL_OUT;
            String message = "Hola, Pepito";


            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("smsto:"+ phoneNumber));  // This ensures only SMS apps respond
            intent.putExtra("sms_body", message);
            intent.putExtra(Intent.EXTRA_STREAM, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Error perrol", Toast.LENGTH_LONG).show();
            }

            /*
            Intent implicit = new Intent(Intent.ACTION_VIEW);
            implicit.setData(Uri.parse("smsto:" + phoneNumber));
            implicit.putExtra("sms_body", message);
            if(getIntent().resolveActivity(getPackageManager()) != null){
                startActivity(implicit);
            } else {
                Toast.makeText(MainActivity.this, "Error launching SMS app", Toast.LENGTH_LONG).show();
            }
            */
        });

        //ACTION_IMAGE_CAPTURE - CAMERA
        buttonCamera.setOnClickListener(view -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(cameraIntent);
            } else {
                Toast.makeText(MainActivity.this, "Error perrol", Toast.LENGTH_LONG).show();
            }
        });
    }
}
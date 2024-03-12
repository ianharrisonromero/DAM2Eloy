package com.example.trainingfragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ColorFragment fragmentRed, fragmentGreen, fragmentBlue;

    FragmentContainerView fragmentContainerViewRed, fragmentContainerViewGreen, fragmentContainerViewBlue;

    Button buttonFragmentRed, buttonFragmentBlue, buttonFragmentGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentRed = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerViewRed);
        fragmentGreen = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerViewGreen);
        fragmentBlue = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerViewBlue);



        buttonFragmentRed = findViewById(R.id.buttonRed);
        buttonFragmentBlue = findViewById(R.id.buttonFragmentBlue);
        buttonFragmentGreen = findViewById(R.id.buttonFragmentGreen);


        View.OnClickListener colorHandlerButton = view -> {
            Button button = (Button) view;
            String buttonName = button.getText().toString().trim().toLowerCase();
            changeColorValue(buttonName);
        };

        buttonFragmentRed.setOnClickListener(colorHandlerButton);
        buttonFragmentBlue.setOnClickListener(colorHandlerButton);
        buttonFragmentGreen.setOnClickListener(colorHandlerButton);

//        View.OnClickListener handler = view -> {
//            Button button = (Button) view;
//            String currentScore = button.getText().toString();
//            int currenIntScore = Integer.parseInt(currentScore);
//            currenIntScore += 1;
//            button.setText(String.valueOf(currenIntScore));
//            if(currenIntScore >= MAX_SCORE){
//                textViewField.setVisibility(View.GONE);
//                buttonRed.setVisibility(View.GONE);
//                buttonBlue.setVisibility(View.GONE);
//                textViewCourt.setVisibility(View.GONE);
//                listener.onGameEnd(courtName + " ->  Red " + buttonRed.getText() + " - " + buttonBlue.getText() + " Blue");
//            }
//        };

    }

    private void changeColorValue(String buttonName) {
//        Fragment fragment;
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        // Check if the fragment already exists in the FragmentManager
//        fragment = fragmentManager.findFragmentByTag(fragmentName);

        // If the fragment doesn't exist, create a new instance
        int c = (int) (Math.random() * 256);

        if (buttonName != null) {
            switch (buttonName) {
                case "red":
                    fragmentRed.changeTvBackground(Color.rgb(0, 0 , c));
                    break;
                case "blue":
                    fragmentBlue.changeTvBackground(Color.rgb(0, 0 , c));
                    break;
                case "green":
                    fragmentGreen.changeTvBackground(Color.rgb(0, c , 0));
                    break;
                default:
                    Toast.makeText(this, "NOT A VALID FRAGMENT NAME", Toast.LENGTH_LONG);
                    break;
            }
        }


    }
}
package com.example.trainingfragmentsapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ColorFragment extends Fragment {

    TextView textViewCount;
    Integer counter = 0;
    boolean isViewCreated = false;
    String backgroundColor;
    Button buttonIncrease,buttonDecrease;

    public ColorFragment(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_color, container, false);

        buttonIncrease = layout.findViewById(R.id.buttonIncrease);
        buttonDecrease = layout.findViewById(R.id.buttonDecrease);
        textViewCount = layout.findViewById(R.id.textViewCount);
        textViewCount.setBackgroundColor(Color.parseColor(backgroundColor));
        isViewCreated = true;


        View.OnClickListener handler = view -> {
            Button button = (Button) view;
            if (button.getText().equals("+")){
                    counter++;
                    textViewCount.setText("" + counter);
            } else {
                counter--;
                textViewCount.setText("" + counter);
            }
        };

        buttonDecrease.setOnClickListener(handler);
        buttonIncrease.setOnClickListener(handler);

        return layout;

    }
}
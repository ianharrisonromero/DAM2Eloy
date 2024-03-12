package com.example.trainingfragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    TextView textViewColorCount;
    boolean isViewCreated = false;


    public ColorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_color, container, false);

        textViewColorCount = layout.findViewById(R.id.textViewColorCount);

        isViewCreated = true;

        return layout;
    }

    public void changeTvBackground(int rgb) {
        if (isViewCreated && textViewColorCount != null) {
            textViewColorCount.setBackgroundColor(rgb);
        }
    }
}
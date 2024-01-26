package com.example.recyclerviewsactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    GalleryGameAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new GalleryFragment())
                    .commit();
        }
    }
}
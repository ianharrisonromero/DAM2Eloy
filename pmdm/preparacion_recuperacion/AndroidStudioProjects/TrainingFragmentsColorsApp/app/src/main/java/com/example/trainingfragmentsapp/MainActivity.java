package com.example.trainingfragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentContainerView fragmentContainerView;
    Button buttonFragmentRed, buttonFragmentBlue, buttonFragmentGreen;
    ColorFragment redFragment, blueFragment, greenFragment;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragments if not already initialized
        if (redFragment == null) {
            redFragment = new ColorFragment("#FF0000");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, redFragment, "red")
                    .commit();
        }

        if (blueFragment == null) {
            blueFragment = new ColorFragment("#0000FF");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, blueFragment, "blue")
                    .hide(blueFragment)
                    .commit();
        }

        if (greenFragment == null) {
            greenFragment = new ColorFragment("#00FF00");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, greenFragment, "green")
                    .hide(greenFragment)
                    .commit();
        }

        // Set current fragment
        currentFragment = redFragment;

        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        buttonFragmentRed = findViewById(R.id.buttonFragmentRed);
        buttonFragmentBlue = findViewById(R.id.buttonFragmentBlue);
        buttonFragmentGreen = findViewById(R.id.buttonFragmentGreen);

        View.OnClickListener fragmentHandlerButton = view -> {
            Button button = (Button) view;
            String fragmentName = button.getText().toString().toLowerCase();
            switchFragment(fragmentName);
        };

        buttonFragmentRed.setOnClickListener(fragmentHandlerButton);
        buttonFragmentBlue.setOnClickListener(fragmentHandlerButton);
        buttonFragmentGreen.setOnClickListener(fragmentHandlerButton);
    }

    private void switchFragment(String fragmentName) {
        Fragment fragmentToShow = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Find the fragment to show
        switch (fragmentName) {
            case "red":
                fragmentToShow = redFragment;
                break;
            case "blue":
                fragmentToShow = blueFragment;
                break;
            case "green":
                fragmentToShow = greenFragment;
                break;
        }

        if (fragmentToShow != null && fragmentToShow != currentFragment) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Hide the current fragment
            fragmentTransaction.hide(currentFragment);

            // Show the fragment to switch to
            fragmentTransaction.show(fragmentToShow);

            // Commit the transaction
            fragmentTransaction.commit();

            // Update the current fragment
            currentFragment = fragmentToShow;
        }
    }
}

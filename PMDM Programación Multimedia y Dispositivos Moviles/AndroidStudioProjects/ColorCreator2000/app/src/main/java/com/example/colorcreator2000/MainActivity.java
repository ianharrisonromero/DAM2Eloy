package com.example.colorcreator2000;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbRed, sbBlue, sbGreen;
    TextView tvWriteName, tvGreenCounter, tvRedCounter, tvBlueCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        tvRedCounter = findViewById(R.id.tvRedCounter);

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the tvRedCounter with the current progress
                tvRedCounter.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed in this case
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed in this case
            }
        });
    }
}

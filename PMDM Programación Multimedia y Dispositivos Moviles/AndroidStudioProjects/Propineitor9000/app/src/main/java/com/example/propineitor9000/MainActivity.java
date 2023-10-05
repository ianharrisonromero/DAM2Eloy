package com.example.propineitor9000;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    TextView tvBill, tvWithTip, tvNumAlert, tvServiceAlert;
    Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btDel,btC,btTip;
    RadioGroup rgService;
    RadioButton rbBad, rbGood, rbExcellent;

    private static final int MAX_DISPLAY_LENGHT = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBill = findViewById(R.id.tvBill);
        tvWithTip = findViewById(R.id.tvWithTip);
        tvNumAlert = findViewById(R.id.tvNumAlert);
        tvServiceAlert = findViewById(R.id.tvServiceAlert);
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        btTip = findViewById(R.id.btTip);
        btC = findViewById(R.id.btC);
        btDel = findViewById(R.id.btDel);
        rbBad = findViewById(R.id.rbBad);
        rbExcellent = findViewById(R.id.rbExcellent);
        rbGood = findViewById(R.id.rbGood);
        rgService = findViewById(R.id.rgService);




        //Numbers tapped to bill display
        OnClickListener btNumberListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btClicked = (Button) view;
                String btText = btClicked.getText().toString();
                String currentText = tvBill.getText().toString();
                if (currentText.length() < MAX_DISPLAY_LENGHT) {
                    String newText = currentText + btText;
                    tvBill.setText(newText);
                } else {
                    tvNumAlert.setVisibility(View.VISIBLE);
                }
            }
        };

        bt0.setOnClickListener(btNumberListener);
        bt1.setOnClickListener(btNumberListener);
        bt2.setOnClickListener(btNumberListener);
        bt3.setOnClickListener(btNumberListener);
        bt4.setOnClickListener(btNumberListener);
        bt5.setOnClickListener(btNumberListener);
        bt6.setOnClickListener(btNumberListener);
        bt7.setOnClickListener(btNumberListener);
        bt8.setOnClickListener(btNumberListener);
        bt9.setOnClickListener(btNumberListener);

        //Tip button
        btTip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tvBill.getText().toString().isEmpty()) {
                    if (rbBad.isChecked() || rbGood.isChecked() || rbExcellent.isChecked()) {
                        String tipString = tvBill.getText().toString();
                        double tip = Double.parseDouble(tipString);
                        if (rbBad.isChecked()) {
                            tip = tip * 0.05;
                            String finalTip = String.format("%.2f", tip);
                            tvWithTip.setText(finalTip + "€");
                        }
                        if (rbGood.isChecked()) {
                            tip = tip * 0.1;
                            String finalTip = String.format("%.2f", tip);
                            tvWithTip.setText(finalTip + "€");
                        }
                        if (rbExcellent.isChecked()) {
                            tip = tip * 0.2;
                            String finalTip = String.format("%.2f", tip);
                            tvWithTip.setText(finalTip + "€");
                        }
                    } else {
                        tvServiceAlert.setVisibility(TextView.VISIBLE);
                    }
                }
            }
        });
        // C button
        btC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvBill.setText("");
                tvWithTip.setText("");
                tvNumAlert.setVisibility(View.INVISIBLE);
                tvServiceAlert.setVisibility(View.INVISIBLE);
                rgService.clearCheck();
            }
        });

        // Deleting button
        btDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvBill.getText().length() > 0) {
                    tvWithTip.setText("");
                    String currentText = tvBill.getText().toString();
                    String newText = currentText.substring(0, currentText.length() - 1);
                    tvBill.setText(newText);
                    if (newText.length() < MAX_DISPLAY_LENGHT) {
                        tvNumAlert.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        //set invisible the service alert if a radio button is selected
        rbBad.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvServiceAlert.setVisibility(View.INVISIBLE);
                tvWithTip.setText("");
            }
        });
        rbGood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvServiceAlert.setVisibility(View.INVISIBLE);
                tvWithTip.setText("");
            }
        });
        rbExcellent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvServiceAlert.setVisibility(View.INVISIBLE);
                tvWithTip.setText("");
            }
        });








    }
}
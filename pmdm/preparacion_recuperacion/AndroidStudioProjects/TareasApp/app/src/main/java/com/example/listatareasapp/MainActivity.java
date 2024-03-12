package com.example.listatareasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckedTextView newCheckTv;
    TextView tvTitle;

    Button buttonAdd, buttonRemove;
    EditText etNewTask;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CheckedTextView> taskList = new ArrayList<>();
//        checkTv = findViewById(R.id.checkTv);
        tvTitle = findViewById(R.id.tvTitle);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonRemove = findViewById(R.id.buttonRemove);
        etNewTask = findViewById(R.id.etNewTask);
        linearLayout = findViewById(R.id.linearLayout);

        buttonAdd.setOnClickListener( v -> {
            String task = etNewTask.getText().toString();
            newCheckTv = new CheckedTextView(this);
            newCheckTv.setText(task);
            newCheckTv.setChecked(false);
            newCheckTv.setOnClickListener( view -> {
                if (newCheckTv.isChecked()){
                    newCheckTv.setChecked(false);
                    newCheckTv.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
                } else {
                    newCheckTv.setChecked(true);
                    newCheckTv.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
                }
            });
            taskList.add(newCheckTv);
            linearLayout.addView(newCheckTv);
        });

        buttonRemove.setOnClickListener( v ->{
            for (CheckedTextView task: taskList) {
                if (task.isChecked()){
                    taskList.remove(task);
                }
            }
        } );





    }
}
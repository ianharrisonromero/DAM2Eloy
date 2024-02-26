package com.example.evernotarios;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextTitle, editTextBody;
    TextView textView1, textView2;
    Button buttonAdd, buttonView;
    ArrayList<Note> notesList = new ArrayList<>();
    static final String NOTE_DATA = "NOTE_DATA";
    NoteBook noteBook = new NoteBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBody = findViewById(R.id.editTextBody);
        editTextTitle = findViewById(R.id.editTextTitle);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity2.RESULT_OK){

                } else if (result.getResultCode() == Activity2.RESULT_CANCELED){
                    Intent data = result.getData();
                    //ejemplo con String
                    noteBook = (NoteBook) data.getSerializableExtra(MainActivity.NOTE_DATA);

                    //hacer algo con el objeto recibido
                } else {
                    //otro error
                }

            }
        });

                buttonAdd.setOnClickListener(view -> {
                    Note note = new Note(
                            editTextTitle.getText().toString(), editTextBody.getText().toString(), Calendar.getInstance()
                    );

                    noteBook.addNote(note);

                    Intent intent = new Intent(this, Activity2.class);
                    intent.putExtra(NOTE_DATA, noteBook);
                    launcher.launch(intent);

                });

    }
}
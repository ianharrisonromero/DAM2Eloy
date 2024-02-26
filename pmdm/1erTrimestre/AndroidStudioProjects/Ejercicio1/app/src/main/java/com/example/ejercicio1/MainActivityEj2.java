//package com.example.ejercicio1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class MainActivityEj2 extends AppCompatActivity {
//
//    Fragment2 fragment1, fragment2;
//
//    final int NUMBER_OF_FRAGMENTS = 4;
//
//    final String COURT1_NAME = "Court 1", COURT2_NAME = "Court 2", COURT3_NAME = "Court 3", COURT4_NAME = "Court 4";
//
//    TextView textViewFinalScores;
//
//    int unfinishedMatches = NUMBER_OF_FRAGMENTS;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        fragment1 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView1);
//        fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
//
//        textViewFinalScores = findViewById(R.id.textViewFinalScores);
//        textViewFinalScores.setText("RESULTS:\n\n");
//        textViewFinalScores.setVisibility(View.GONE);
//
//        fragment1.setCourtName(COURT1_NAME);
//        fragment2.setCourtName(COURT2_NAME);
//
//    }
//
//    @Override
//    public void onGameEnd(CharSequence score) {
//        textViewFinalScores.append(score + "\n");
//        unfinishedMatches -= 1;
//        if(unfinishedMatches == 0){
//            textViewFinalScores.setVisibility(View.VISIBLE);
//        }
//    }
//}
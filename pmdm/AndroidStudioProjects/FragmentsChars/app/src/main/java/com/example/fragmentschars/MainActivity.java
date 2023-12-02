package com.example.fragmentschars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements CharacterSelectionFragment.OnCharacterChange {

    CharacterSelectionFragment fragment1,fragment2;
    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = (CharacterSelectionFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView1);
        fragment2 = (CharacterSelectionFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);

    }

    @Override
    public void onCharacterChange(GameCharacter character) {
        if (character.equals(GameCharacter.MIC))
        imageView1.setImageResource(R.drawable.frodo);
    }


}
package com.example.fragmentschars;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements CharacterSelectionFragment.OnCharacterChange {

    CharacterSelectionFragment fragment1,fragment2;
    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        fragment1 = (CharacterSelectionFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView1);
        fragment2 = (CharacterSelectionFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);

    }

    @Override
    public void onCharacterChange(GameCharacter character, CharacterSelectionFragment fragment) {

        //SWITCH PARA VER QUÉ FRAGMENT (JUGADOR) HA CLICKEADO
        int fragmentSwitcher;
        if (fragment == fragment1){
            fragmentSwitcher = 1;
        } else {
            fragmentSwitcher = 2;
        }

        switch (fragmentSwitcher){
            case 1 :
                if (character == GameCharacter.FRODO){
                    imageView1.setImageResource(R.drawable.frodo);
                    fragment2.iv1.setClickable(false);
                    fragment2.iv1.setColorFilter(Color.GRAY);
                } else if (character == GameCharacter.GANDALF) {
                    imageView1.setImageResource(R.drawable.gandalf);
                    fragment2.iv2.setClickable(false);
                    fragment2.iv2.setColorFilter(Color.GRAY);
                } else if (character == GameCharacter.LEGOLAS) {
                    imageView1.setImageResource(R.drawable.legolas);
                    fragment2.iv3.setClickable(false);
                    fragment2.iv3.setColorFilter(Color.GRAY);
                }
                break;
            case 2 :
                if (character == GameCharacter.FRODO){
                    imageView2.setImageResource(R.drawable.frodo);
                } else if (character == GameCharacter.GANDALF) {
                    imageView2.setImageResource(R.drawable.gandalf);
                } else if (character == GameCharacter.LEGOLAS) {
                    imageView2.setImageResource(R.drawable.legolas);
                }
        }


    }


}
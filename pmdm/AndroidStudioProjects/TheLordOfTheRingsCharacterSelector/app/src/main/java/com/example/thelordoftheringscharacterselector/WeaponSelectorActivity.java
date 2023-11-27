package com.example.thelordoftheringscharacterselector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WeaponSelectorActivity extends AppCompatActivity {

    ImageView ivSword, ivRing, ivBow, ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_selector);


        ivSword = findViewById(R.id.ivSword);
        ivRing = findViewById(R.id.ivRing);
        ivBow = findViewById(R.id.ivBow);
        ivBack = findViewById(R.id.ivBack);


        Intent intent = getIntent();
        String playerTag = intent.getStringExtra(MainActivity.PLAYER_TAG);

        ivSword.setOnClickListener(v -> {
            handleWeaponSelection(MainActivity.PLAYER_TAG, playerTag,
                                    MainActivity.WEAPON_TAG, LOTRWeapons.SWORD.toString());
        });

        ivRing.setOnClickListener(v -> {
            handleWeaponSelection(MainActivity.PLAYER_TAG, playerTag,
                    MainActivity.WEAPON_TAG, LOTRWeapons.RING.toString());
        });

        ivBow.setOnClickListener(v -> {
            handleWeaponSelection(MainActivity.PLAYER_TAG, playerTag,
                    MainActivity.WEAPON_TAG, LOTRWeapons.BOW.toString());
        });

        ivBack.setOnClickListener(v -> {
            finish();
        });



    }

    public void handleWeaponSelection(String PLAYER_TAG, String playerTag,
                                         String WEAPON_TAG, String weaponName){
        Intent intent = new Intent();
        intent.putExtra(MainActivity.PLAYER_TAG, playerTag);
        intent.putExtra(MainActivity.WEAPON_TAG, weaponName);
        setResult(RESULT_OK, intent);
        finish();

    }

}
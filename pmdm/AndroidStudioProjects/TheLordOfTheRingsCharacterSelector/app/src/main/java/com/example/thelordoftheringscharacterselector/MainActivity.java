package com.example.thelordoftheringscharacterselector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivTitle, ivChar1, ivChar2, ivWeapon1, ivWeapon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTitle = findViewById(R.id.ivTitle);
        ivChar1 = findViewById(R.id.ivChar1);
        ivChar2 = findViewById(R.id.ivChar2);
        ivWeapon1 = findViewById(R.id.ivWeapon1);
        ivWeapon2 = findViewById(R.id.ivWeapon2);


        
    }

    public void charSelector (String playerTag){
        Intent intent = new Intent(this, CharacterSelectorActivity.class);
        intent.putExtra("playerTag", playerTag);
        startActivity(intent);
    }

    public void weaponSelector (String weaponTag){
        Intent intent = new Intent(this, weaponSelectorActivity.class);
        intent.putExtra("weaponTag", weaponTag);
        startActivity(intent);
    }
}
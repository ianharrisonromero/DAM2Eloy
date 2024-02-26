package com.example.pokemonapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textViewInfo;
    EditText editTextInput;
    Button buttonCallApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewInfo = findViewById(R.id.textViewInfo);
        editTextInput = findViewById(R.id.editTextInput);
        buttonCallApi = findViewById(R.id.buttonCallApi);

        buttonCallApi.setOnClickListener(view -> {

            PokeService pokeService = PokeService.getInstance();
            Call<Pokemon> pokemonCall = pokeService.getPokemonRepo().getPokemon(editTextInput.getText().toString().trim());

            pokemonCall.enqueue(new Callback<Pokemon>(){
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    Pokemon pokemon = response.body();
                    textViewInfo.setText(pokemon.toString());
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    textViewInfo.setText("Error al buscar la información");
                }
            });
        });


    }


}
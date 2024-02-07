package com.iehr.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

        EditText id;
        Button get;
        TextView info;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            id = findViewById(R.id.ut09a1_id);
            get = findViewById(R.id.ut09a1_get);
            info = findViewById(R.id.ut09a1_info);

            get.setOnClickListener((v) -> {
                int characterId = Integer.parseInt(id.getText().toString());
                fetchCharacter(characterId);
            });
        }

        private void fetchCharacter(int characterId) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://rickandmortyapi.com/api/character/" + characterId)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        Personaje personaje = gson.fromJson(response.body().string(), Personaje.class);

                        runOnUiThread(() -> {
                            displayCharacterInfo(personaje);
                        });
                    }
                }
            });
        }

        private void displayCharacterInfo(Personaje personaje) {
            if (personaje != null) {
                info.setText("Name: " + personaje.name + "\n" +
                        "Status: " + personaje.status + "\n" +
                        "Species: " + personaje.species + "\n" +
                        "Type: " + personaje.type + "\n" +
                        "Gender: " + personaje.gender);
            }
        }
    }

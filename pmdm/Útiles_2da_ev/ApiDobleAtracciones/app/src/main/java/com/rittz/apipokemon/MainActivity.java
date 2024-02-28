package com.rittz.apipokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button buttonApiCall;
    EditText editTextInput;
    TextView textViewInfo;
    ImageView imageViewSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonApiCall = findViewById(R.id.buttonCallApi);
        editTextInput = findViewById(R.id.editTextInput);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewSprite = findViewById(R.id.imageViewSprite);

        buttonApiCall.setOnClickListener((v)->{

            //convertimos input a integer para más adelante poder restarle
            int etInput = Integer.parseInt(editTextInput.getText().toString());

            if (!editTextInput.getText().toString().trim().isEmpty()){

            }

            AtraccionService service = AtraccionService.getInstance();
            textViewInfo.setText(editTextInput.getText().toString().toLowerCase().trim());
            try {
                Thread.sleep(1000);
            } catch (Exception e){}

            Call<List<Atraccion>> llamada =  service.getRepo().getAtracciones();

            llamada.enqueue(new Callback<List<Atraccion>>() {

                @Override
                public void onResponse(Call<List<Atraccion>> call, Response<List<Atraccion>> response) {
                    List<Atraccion> listaAtracciones = response.body();
                    //aqúi iría bien un "if (listaAtracciones != null) para asegurar

                    String idBuscar = listaAtracciones.get(etInput - 1).url;

                    textViewInfo.setText(pokemon.toString());
                    String imageUrl = pokemon.getSprites().getFront_default();
                    //Toast.makeText(getApplicationContext(), imageUrl, Toast.LENGTH_LONG).show();

                    Glide.with(getApplicationContext())
                            .load(imageUrl)
                            .into(imageViewSprite);

                }

                @Override
                public void onFailure(Call<Atraccion> call, Throwable t) {
                    textViewInfo.setText("Error al buscar la información");
                }
            });

        });




    }
}
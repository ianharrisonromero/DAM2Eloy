package com.example.pokemonapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.*;

public class PokeService {
    private static PokeService pokeServiceInstance;
    private static PokemonRepo pokemonRepo;

    private PokeService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonRepo = retrofit.create(PokemonRepo.class);

    }

    public static PokemonRepo getPokemonRepo(){
        return pokemonRepo;
    }

    public static PokeService getInstance(){
        if (pokeServiceInstance == null){
            pokeServiceInstance = new PokeService();
        }
        return pokeServiceInstance;
    }
}

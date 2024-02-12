package com.example.pokemonapi;

import retrofit2.*;
import retrofit2.http.*;

public interface PokemonRepo {
    @GET("api/v2/pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);

}

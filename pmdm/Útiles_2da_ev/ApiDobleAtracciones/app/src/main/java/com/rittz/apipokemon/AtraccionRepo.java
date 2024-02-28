package com.rittz.apipokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AtraccionRepo {
    @GET("atracciones/") //en vez de /v2/pokemon/{name} , eso lo haremos en la segunda llamada
    Call<List<Atraccion>> getAtracciones();

    @GET("atracciones/{id}") //en vez de /v2/pokemon/{name} , eso lo haremos en la segunda llamada
    Call<Atraccion> getAtraccion(String id);
}

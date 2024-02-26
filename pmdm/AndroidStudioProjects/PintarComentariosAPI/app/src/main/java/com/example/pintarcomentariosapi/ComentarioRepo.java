package com.example.pintarcomentariosapi;

import java.util.List;
        import retrofit2.Call;
        import retrofit2.http.GET;

public interface ComentarioRepo {
    @GET("comentarios/")
    Call<List<Comentario>> getComentarios();
}
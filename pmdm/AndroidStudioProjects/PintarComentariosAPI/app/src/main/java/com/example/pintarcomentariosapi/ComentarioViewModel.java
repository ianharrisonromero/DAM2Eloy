package com.example.pintarcomentariosapi;

// ComentarioViewModel.java
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComentarioViewModel extends ViewModel {
    private MutableLiveData<List<Comentario>> comentariosLiveData;
    private ComentarioRepo comentarioRepo;

    public LiveData<List<Comentario>> getComentarios() {
        if (comentariosLiveData == null) {
            comentariosLiveData = new MutableLiveData<>();
            cargarComentarios();
        }
        return comentariosLiveData;
    }

    public void cargarComentarios() {
        comentarioRepo = RetrofitComentarioService.getInstance().create(ComentarioRepo.class);
        comentarioRepo.getComentarios().enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                if (response.isSuccessful()) {
                    comentariosLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {

            }
        });
    }
}

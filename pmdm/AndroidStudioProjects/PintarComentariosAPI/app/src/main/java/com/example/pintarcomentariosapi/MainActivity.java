package com.example.pintarcomentariosapi;

// MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ComentarioViewModel comentarioViewModel;
    private ComentarioAdapter comentarioAdapter;
    private Button btnLoadComentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadComentarios = findViewById(R.id.btnLoadComentarios);
        btnLoadComentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarComentarios();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        comentarioAdapter = new ComentarioAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(comentarioAdapter);

        comentarioViewModel = new ViewModelProvider(this).get(ComentarioViewModel.class);
        // No necesitamos observar el LiveData aquí, ya que actualizaremos los comentarios
        // en el método cargarComentarios() directamente.
    }

    private void cargarComentarios() {
        comentarioViewModel.cargarComentarios();
        // Los comentarios se actualizarán en el ViewModel, el adaptador se actualizará automáticamente
    }
}


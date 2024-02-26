package com.example.pintarcomentariosapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder> {
    private Context context;
    private List<Comentario> comentarios;

    public ComentarioAdapter(Context context, List<Comentario> comentarios) {
        this.context = context;
        this.comentarios = comentarios;
    }

    @NonNull
    @Override
    public ComentarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comentario, parent, false);
        return new ComentarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioViewHolder holder, int position) {
        Comentario comentario = comentarios.get(position);
        holder.textoTextView.setText(comentario.getTexto());
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public static class ComentarioViewHolder extends RecyclerView.ViewHolder {
        TextView textoTextView;

        public ComentarioViewHolder(@NonNull View itemView) {
            super(itemView);
            textoTextView = itemView.findViewById(R.id.textoTextView);
        }
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
        notifyDataSetChanged(); // Notificar al RecyclerView que los datos han cambiado
    }
}


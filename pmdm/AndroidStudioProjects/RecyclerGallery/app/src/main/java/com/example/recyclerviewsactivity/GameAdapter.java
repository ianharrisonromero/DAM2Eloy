package com.example.recyclerviewsactivity;

import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private ArrayList<GameModel> gameList;

    public GameAdapter(ArrayList<GameModel> gameList) {
        this.gameList = gameList;
    }

    // ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Define your UI elements here
        public ImageView imageViewGame;
        TextView gameUserCreator;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize UI elements
            imageViewGame = itemView.findViewById(R.id.gamePhoto);
            // You should replace R.id.imageViewGame with the actual ID used in your item layout
            gameUserCreator = itemView.findViewById(R.id.gameUserCreator);

        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to UI elements
        GameModel game = gameList.get(position);

        // Set data to UI elements in the ViewHolder
        holder.imageViewGame.setImageResource(game.getGamePhoto());
        // You can also set other data like text views, etc.
        holder.gameUserCreator.setText(game.getGameUserCreator());

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}


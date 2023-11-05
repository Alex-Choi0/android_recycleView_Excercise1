package com.example.recycleview_excercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private ArrayList<String> gameTitle;
    private ArrayList<String> gameDetails;
    private ArrayList<Integer> gameImages;
    private Context context;

    public GameAdapter(ArrayList<String> gameTitle, ArrayList<String> gameDetails, ArrayList<Integer> gameImages, Context context) {
        this.gameTitle = gameTitle;
        this.gameDetails = gameDetails;
        this.gameImages = gameImages;
        this.context = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_ele, parent, false);
        return new GameViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.gameTitleView.setText(gameTitle.get(position));
        holder.gameDetailsView.setText(gameDetails.get(position));
        holder.imageViews.setImageResource(gameImages.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You click " + gameTitle.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.gameTitle.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        private TextView gameTitleView, gameDetailsView;
        private ImageView imageViews;
        private CardView cardView;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);

            gameTitleView = itemView.findViewById(R.id.gameTitleView);
            gameDetailsView = itemView.findViewById(R.id.gemeDetailsView);
            imageViews = itemView.findViewById(R.id.gameImageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

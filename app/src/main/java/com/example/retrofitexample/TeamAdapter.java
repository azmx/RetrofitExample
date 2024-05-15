package com.example.retrofitexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> teams;

    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamNameTextView.setText(team.getStrTeam());
        holder.teamIdTextView.setText(team.getIdTeam());
        Glide.with(holder.itemView.getContext()).load(team.getStrTeamBadge()).into(holder.teamBadgeImageView);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        ImageView teamBadgeImageView;
        TextView teamIdTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.tvname);
            teamBadgeImageView = itemView.findViewById(R.id.imageView);
            teamIdTextView = itemView.findViewById(R.id.tvDesc);
        }
    }
}

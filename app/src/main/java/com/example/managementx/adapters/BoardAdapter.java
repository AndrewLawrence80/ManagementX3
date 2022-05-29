package com.example.managementx.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managementx.BoardActivity;
import com.example.managementx.R;
import com.example.managementx.beans.Team;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private List<Team> teamList;
    private Context context;

    public BoardAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.boardName.setText(team.getTeamName());

        //holder.itemView.setBackgroundColor();
        holder.itemView.setOnClickListener((v) -> {
            Intent intent = new Intent(context, BoardActivity.class);
            intent.putExtra("teamId", team.getObjectId());
            intent.putExtra("teamName", team.getTeamName());
            Toast.makeText(context, "看板详情", Toast.LENGTH_SHORT).show();
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView boardName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            boardName = (TextView) itemView.findViewById(R.id.board_name);
        }
    }



}

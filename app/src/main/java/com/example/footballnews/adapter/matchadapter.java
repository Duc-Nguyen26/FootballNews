package com.example.footballnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.activity.main.DetailMatch;
import com.example.footballnews.model.viewmatch;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class matchadapter extends RecyclerView.Adapter<matchadapter.MyViewHolder> {
    Context contextm;
    ArrayList<viewmatch> viewmatchs;
    public  matchadapter (Context ct , ArrayList<viewmatch> vm){
        contextm = ct;
        viewmatchs = vm;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(contextm).inflate(R.layout.view_match, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final matchadapter.MyViewHolder holder, final int position) {
        holder.tvScore1.setText(viewmatchs.get(position).getScore1());
        holder.tvScore2.setText(viewmatchs.get(position).getScore2());
        holder.tvTimematch.setText(viewmatchs.get(position).getTime());
        holder.tvFTHT.setText(viewmatchs.get(position).getFTHT());
        holder.tvStage.setText(viewmatchs.get(position).getStage());
        holder.tvName1.setText(viewmatchs.get(position).getName1());
        holder.tvName2.setText(viewmatchs.get(position).getName2());
        holder.tvLeague.setText(viewmatchs.get(position).getLeague());
        holder.tvround.setText(viewmatchs.get(position).getRound());
        Picasso.get().load(viewmatchs.get(position).getTeam1()).into(holder.ivTeam1);
        Picasso.get().load(viewmatchs.get(position).getTeam2()).into(holder.ivTeam2) ;
        holder.ivTeam1.setTag(viewmatchs.get(position).getKey());
        holder.ivTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailMatch.class);
                int position= holder.getAdapterPosition();
                viewmatch match =  viewmatchs.get(position);
                intent.putExtra("Match", match);
                contextm.startActivity(intent);

            }
        });
        holder.btSeemore.setTag(viewmatchs.get(position).getKey());
        holder.btSeemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), DetailMatch.class);
                int position1 = holder.getAdapterPosition();
                viewmatch match1 = viewmatchs.get(position1);
                intent1.putExtra("Match", match1);
                contextm.startActivity(intent1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return viewmatchs.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvScore1, tvScore2, tvTimematch,tvFTHT, tvStage, tvName1, tvName2, tvLeague, tvround;
        ImageView ivTeam1, ivTeam2;
        Button btSeemore;
        public MyViewHolder(View view) {
            super(view);
            ivTeam1 = (ImageView) view.findViewById(R.id.idTeam1);
            ivTeam2 = (ImageView) view.findViewById(R.id.idTeam2);
            tvScore1 = (TextView) view.findViewById(R.id.idScore1);
            tvScore2 = (TextView) view.findViewById(R.id.idScore2);
            tvTimematch = (TextView) view.findViewById(R.id.idTimematch);
            tvFTHT =  (TextView) view.findViewById(R.id.idFulltime);
            tvStage = (TextView) view.findViewById(R.id.idStage);
            tvName1 = (TextView) view.findViewById(R.id.idName1);
            tvName2 = (TextView) view.findViewById(R.id.idName2);
            tvround = (TextView) view.findViewById(R.id.idroudmatch);
            tvLeague = (TextView) view.findViewById(R.id.idLeagueMatch);
            btSeemore = (Button) view.findViewById(R.id.idSeemore);
        }
    }
}

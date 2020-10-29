package com.example.footballnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.model.viewlichday;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class lichdayadapter extends RecyclerView.Adapter<lichdayadapter.MyViewHolder> {
    Context context;
    ArrayList<viewlichday> viewlichdays;
    public lichdayadapter (Context c ,ArrayList<viewlichday> vld){
        context = c;
        viewlichdays = vld;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewlich,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvday.setText(viewlichdays.get(position).getDay());
        holder.tvtime.setText(viewlichdays.get(position).getTime());
        holder.tvstage.setText(viewlichdays.get(position).getStage());
        holder.tvleague.setText(viewlichdays.get(position).getLeague());
        holder.tvhalf.setText(viewlichdays.get(position).getHalf());
        holder.tvname1.setText(viewlichdays.get(position).getName1());
        holder.tvname2.setText(viewlichdays.get(position).getName2());
        holder.tvscore1.setText(viewlichdays.get(position).getScore1());
        holder.tvscore2.setText(viewlichdays.get(position).getScore2());
        Picasso.get().load(viewlichdays.get(position).getTeam1()).into(holder.ivteam1);
        Picasso.get().load(viewlichdays.get(position).getTeam2()).into(holder.ivteam2);
    }

    @Override
    public int getItemCount() {
        return viewlichdays.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvday, tvtime, tvleague,tvstage,tvhalf,tvname1,tvname2, tvscore1, tvscore2;
        ImageView ivteam1, ivteam2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvday = (TextView) itemView.findViewById(R.id.idtvlichday);
            tvtime = (TextView) itemView.findViewById(R.id.idtimelichday);
            tvleague = (TextView) itemView.findViewById(R.id.idLeaguelichday);
            tvstage = (TextView) itemView.findViewById(R.id.idStagelichday);
            tvhalf =  (TextView) itemView.findViewById(R.id.idFTlich);
            tvname1 = (TextView) itemView.findViewById(R.id.idName1lich);
            tvname2 =  (TextView) itemView.findViewById(R.id.idName2lich);
            ivteam1 = (ImageView) itemView.findViewById(R.id.idteam1lich);
            ivteam2 = (ImageView) itemView.findViewById(R.id.idteam2lich);
            tvscore1 = (TextView) itemView.findViewById(R.id.idScore1ichday);
            tvscore2=  (TextView) itemView.findViewById(R.id.idScore2lichday);
        }
    }
}

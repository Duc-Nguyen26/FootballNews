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

public class lichtomorrowadapter extends RecyclerView.Adapter<lichtomorrowadapter.MyViewHolder> {
    Context context;
    ArrayList<viewlichday> viewlichdayr;
    public  lichtomorrowadapter (Context c, ArrayList<viewlichday> vldr){
        context = c;
        viewlichdayr = vldr;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewlich,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvdayt.setText(viewlichdayr.get(position).getDay());
        holder.tvtimet.setText(viewlichdayr.get(position).getTime());
        holder.tvstaget.setText(viewlichdayr.get(position).getStage());
        holder.tvhalft.setText(viewlichdayr.get(position).getHalf());
        holder.tvleaguet.setText(viewlichdayr.get(position).getLeague());
        holder.tvname1t.setText(viewlichdayr.get(position).getName1());
        holder.tvname2t.setText(viewlichdayr.get(position).getName2());
        holder.tvscore1t.setText(viewlichdayr.get(position).getScore1());
        holder.tvscore2t.setText(viewlichdayr.get(position).getScore2());
        Picasso.get().load(viewlichdayr.get(position).getTeam1()).into(holder.ivteam1t);
        Picasso.get().load(viewlichdayr.get(position).getTeam2()).into(holder.ivteam2t);
    }

    @Override
    public int getItemCount() {
        return viewlichdayr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvdayt, tvtimet, tvstaget, tvleaguet, tvhalft, tvname1t , tvname2t, tvscore1t, tvscore2t;
        ImageView ivteam1t, ivteam2t;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdayt = (TextView) itemView.findViewById(R.id.idtvlichday);
            tvtimet = (TextView) itemView.findViewById(R.id.idtimelichday);
            tvstaget = (TextView) itemView.findViewById(R.id.idStagelichday);
            tvleaguet = (TextView) itemView.findViewById(R.id.idLeaguelichday);
            tvhalft = (TextView) itemView.findViewById(R.id.idFTlich);
            tvname1t =  (TextView) itemView.findViewById(R.id.idName1lich);
            tvname2t = (TextView) itemView.findViewById(R.id.idName2lich);
            tvscore1t = (TextView) itemView.findViewById(R.id.idScore1ichday);
            tvscore2t = (TextView) itemView.findViewById(R.id.idScore2lichday);
            ivteam1t= (ImageView) itemView.findViewById(R.id.idteam1lich);
            ivteam2t = (ImageView) itemView.findViewById(R.id.idteam2lich);
        }
    }
}

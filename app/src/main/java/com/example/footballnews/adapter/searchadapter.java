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
import com.example.footballnews.model.viewsearch;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class searchadapter  extends RecyclerView.Adapter<searchadapter.MyViewHolder> {
    Context context;
    ArrayList<viewsearch> viewsearches;
    public searchadapter  (Context ct , ArrayList<viewsearch> vm){
        context = ct;
        viewsearches = vm;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewsearch,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvheader.setText(viewsearches.get(position).getHeader());
        holder.tvtime.setText(viewsearches.get(position).getTime());
        holder.tvleague.setText(viewsearches.get(position).getLeague());
        holder.tvsource.setText(viewsearches.get(position).getSource());
        Picasso.get().load(viewsearches.get(position).getPicture()).into(holder.ivpicture);
    }

    @Override
    public int getItemCount() {
        return viewsearches.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvheader, tvtime, tvleague, tvsource;
        ImageView ivpicture;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvheader = (TextView) itemView.findViewById(R.id.idHeadersearch);
            tvtime = (TextView) itemView.findViewById(R.id.idTimesearch);
            tvleague = (TextView) itemView.findViewById(R.id.idLeaguesearch);
            tvsource =(TextView) itemView.findViewById(R.id.idSourcesearch);
            ivpicture = (ImageView) itemView.findViewById(R.id.idpicturesearch);
        }
    }
}

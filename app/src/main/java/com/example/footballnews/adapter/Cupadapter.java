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
import com.example.footballnews.activity.main.Detailcup;
import com.example.footballnews.model.viewcup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Cupadapter extends RecyclerView.Adapter<Cupadapter.MyViewHolder> {
    Context context;
    ArrayList<viewcup> viewcups;

    public Cupadapter(Context c, ArrayList<viewcup> vc) {
        context = c;
        viewcups = vc;
    }

    @NonNull
    @Override
    public Cupadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Cupadapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewcup, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final Cupadapter.MyViewHolder holder, int position) {
        holder.Headercup.setText(viewcups.get(position).getHeader());
        holder.Descriptioncup.setText(viewcups.get(position).getDescription());
        Picasso.get().load(viewcups.get(position).getImage()).into(holder.Imagecup);
        holder.btDetailcup.setTag(viewcups.get(position).getKey());
        holder.btDetailcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), Detailcup.class);
                int position = holder.getAdapterPosition();
                viewcup cup = viewcups.get(position);
                intent.putExtra("cup", cup);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewcups.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Headercup,Descriptioncup;
        ImageView Imagecup;
        Button btDetailcup;
        public MyViewHolder(View itemView) {
            super(itemView);
            Headercup = (TextView) itemView.findViewById(R.id.idHeadercup);
            Descriptioncup = (TextView) itemView.findViewById(R.id.idDescriptioncup);
            Imagecup= (ImageView) itemView.findViewById(R.id.idImagecup);
            btDetailcup= (Button) itemView.findViewById(R.id.idDetailcup);
        }
    }
}

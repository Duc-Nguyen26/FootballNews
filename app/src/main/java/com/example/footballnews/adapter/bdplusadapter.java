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
import com.example.footballnews.activity.main.Detailbdplus;
import com.example.footballnews.model.viewbdplus;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class bdplusadapter extends RecyclerView.Adapter<bdplusadapter.MyViewHolder> {
    Context context;
    ArrayList<viewbdplus> viewbdpluses;

    public bdplusadapter(Context c, ArrayList<viewbdplus> d) {
        context = c;
        viewbdpluses = d;
    }

    @NonNull
    @Override
    public bdplusadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new bdplusadapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewbdplus, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull final bdplusadapter.MyViewHolder holder, int position) {
        holder.Headerbdplus.setText(viewbdpluses.get(position).getHeader());
        holder.Descriptionbdplus.setText(viewbdpluses.get(position).getDescription());
        Picasso.get().load(viewbdpluses.get(position).getImage()).into(holder.Imagebdplus);
        holder.btDetailbdplus.setTag( viewbdpluses.get(position).getKey());
        holder.btDetailbdplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), Detailbdplus.class);
                int position = holder.getAdapterPosition();
                viewbdplus bdplus = viewbdpluses.get(position);
                intent1.putExtra("bplus", bdplus);
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewbdpluses.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Headerbdplus, Descriptionbdplus;
        ImageView Imagebdplus;
        Button btDetailbdplus;

        public MyViewHolder(View itemView) {
            super(itemView);
            Headerbdplus = (TextView) itemView.findViewById(R.id.idHeaderbdp);
            Descriptionbdplus = (TextView) itemView.findViewById(R.id.idDescriptionbdp);
            Imagebdplus = (ImageView) itemView.findViewById(R.id.idImagebdp);
            btDetailbdplus = (Button) itemView.findViewById(R.id.idDetailbdp);
        }
    }
}

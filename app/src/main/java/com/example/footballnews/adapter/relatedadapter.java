package com.example.footballnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.model.viewRelated;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class relatedadapter extends RecyclerView.Adapter<relatedadapter.MyViewHolder> {
    Context context;
    ArrayList<viewRelated> viewRelateds;
    public  relatedadapter (Context c ,ArrayList<viewRelated> r){
        context = c;
        viewRelateds = r;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new relatedadapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewrelated, parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTittle.setText(viewRelateds.get(position).getHeader());
        holder.tvSource.setText(viewRelateds.get(position).getSource());
        holder.tvTime.setText(viewRelateds.get(position).getTime());
        holder.tvLeague.setText(viewRelateds.get(position).getLeague());
        Picasso.get().load(viewRelateds.get(position).getImage()).into(holder.ivRelated);
        holder.btseeRelated.setTag(viewRelateds.get(position).getKey());
        holder.btseeRelated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return viewRelateds.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTittle,tvSource, tvTime,tvLeague;
        ImageView ivRelated;
        Button btseeRelated;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTittle = (TextView) itemView.findViewById(R.id.idTittleRelated);
            tvSource = (TextView) itemView.findViewById(R.id.idSoureRelated);
            tvTime = (TextView) itemView.findViewById(R.id.idTimeRelated);
            tvLeague = (TextView) itemView.findViewById(R.id.idLeagueRelated);
            ivRelated = (ImageView) itemView.findViewById(R.id.idimageRelated);
            btseeRelated = (Button) itemView.findViewById(R.id.idbtRelated);
        }
    }
}

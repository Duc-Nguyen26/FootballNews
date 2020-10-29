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
import com.example.footballnews.activity.main.Detail24h;
import com.example.footballnews.model.view24h;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class b24hadapter  extends RecyclerView.Adapter<b24hadapter.MyViewHolder> {
    Context context;
    ArrayList<view24h> view24hs;
    public  b24hadapter(Context c , ArrayList<view24h> v){
        context = c;
        view24hs = v;
    }
    @NonNull
    @Override
    public b24hadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.view24h, parent, false));
    }

    @Override

    public void onBindViewHolder(@NonNull final b24hadapter.MyViewHolder holder, int position) {
        holder.Header24h.setText(view24hs.get(position).getHeader());
        holder.Description24h.setText(view24hs.get(position).getDescription());
        Picasso.get().load(view24hs.get(position).getImage()).into(holder.Image24h);
        holder.btDetail24h.setTag( view24hs.get(position).getKey());
        holder.btDetail24h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detail24h.class);
                int position = holder.getAdapterPosition();
                view24h b24h = view24hs.get(position);
                intent.putExtra("b24h", b24h);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return view24hs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Header24h,Description24h;
        ImageView Image24h;
        Button btDetail24h;
        public MyViewHolder(View itemView) {
            super(itemView);
            Header24h = (TextView) itemView.findViewById(R.id.idHeader24h);
            Description24h = (TextView) itemView.findViewById(R.id.idDescription24h);
            Image24h = (ImageView) itemView.findViewById(R.id.idImage24h);
            btDetail24h = (Button) itemView.findViewById(R.id.idDetail24h);
        }

    }
}

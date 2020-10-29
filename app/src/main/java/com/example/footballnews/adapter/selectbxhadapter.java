package com.example.footballnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.model.viewselectbxh;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class selectbxhadapter extends RecyclerView.Adapter<selectbxhadapter.MyViewHolder> {
    Context context;
    ArrayList<viewselectbxh> viewselectbxhs;
    public  selectbxhadapter (Context c, ArrayList<viewselectbxh> vs){
        context = c;
        viewselectbxhs = vs;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewselectbxh, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(viewselectbxhs.get(position).getImage()).into(holder.ibselectbxh);
    }

    @Override
    public int getItemCount() {
        return viewselectbxhs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ibselectbxh;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ibselectbxh = (ImageView) itemView.findViewById(R.id.idibselectbxh);
        }
    }
}

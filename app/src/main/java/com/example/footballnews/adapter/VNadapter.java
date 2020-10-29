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
import com.example.footballnews.activity.main.Detailvn;
import com.example.footballnews.model.viewVN;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VNadapter extends RecyclerView.Adapter<VNadapter.MyViewHolder> {
    Context  context;
    ArrayList<viewVN> viewVNS;
    public VNadapter (Context c , ArrayList<viewVN> p){
        context = c;
        viewVNS= p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VNadapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.viewvn, parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.Header.setText(viewVNS.get(position).getHeader());
        holder.Description.setText(viewVNS.get(position).getDescription());
        Picasso.get().load(viewVNS.get(position).getImage()).into(holder.imageVN);
        holder.btDetail.setTag(viewVNS.get(position).getKey());
        holder.btDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), Detailvn.class);
                int position = holder.getAdapterPosition();
                viewVN vns = viewVNS.get(position);
                intent.putExtra("VNS", vns);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewVNS.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Header,Description;
        ImageView imageVN;
        Button btDetail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Header = (TextView) itemView.findViewById(R.id.idHeaderVN);
            Description = (TextView) itemView.findViewById(R.id.idDescriptionVN);
            imageVN =  (ImageView) itemView.findViewById(R.id.idImageVN);
            btDetail= (Button) itemView.findViewById(R.id.idDetailVN);
        }
    }
}

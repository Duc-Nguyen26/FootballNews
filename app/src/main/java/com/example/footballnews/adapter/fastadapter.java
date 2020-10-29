package com.example.footballnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.activity.main.Detailfast;
import com.example.footballnews.model.viewfast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class fastadapter extends RecyclerView.Adapter<fastadapter.fastMyViewHolder> {
    Context context;
    ArrayList<viewfast> viewfasts;
    long DURATION = 500;
    private boolean on_attach = true;
    public  fastadapter(Context c , ArrayList<viewfast> p){
        context = c;
        viewfasts = p;
    }

    public fastadapter(ArrayList<viewfast> viewfasts) {
    }

    @NonNull
    @Override
    public fastMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new fastMyViewHolder(LayoutInflater.from(context).inflate(R.layout.fastcard, parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final fastMyViewHolder holder, final int position) {
        holder.Header.setText(viewfasts.get(position).getHeader());
        holder.Time.setText(viewfasts.get(position).getTime());
        holder.Source.setText(viewfasts.get(position).getSource());
        holder.League.setText(viewfasts.get(position).getLeague());
        Picasso.get().load(viewfasts.get(position).getImage()).into(holder.Avatar);
        holder.Header.setTag( viewfasts.get(position).getKey());
//        setAnimation(holder.itemView, position);
        holder.Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detailfast.class);
                int position = holder.getAdapterPosition();
                viewfast news = viewfasts.get(position);
                intent.putExtra("news", news);
                context.startActivity(intent);
            }
        });
        holder.Avatar.setTag(viewfasts.get(position).getKey());
        holder.Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(),Detailfast.class);
                int position = holder.getAdapterPosition();
                viewfast news1 = viewfasts.get(position);
                intent1.putExtra("news", news1);
                context.startActivity(intent1);
            }
        });
        holder.Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), Detailfast.class);
                int postion = holder.getAdapterPosition();
                viewfast news2 = viewfasts.get(position);
                intent2.putExtra("new", news2);
                context.startActivity(intent2);
            }
        });
        holder.League.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), Detailfast.class);
                int position = holder.getAdapterPosition();
                viewfast news3 = viewfasts.get(position);
                intent3.putExtra("news", news3);
                context.startActivity(intent3);
            }
        });
        holder.Source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(v.getContext(), Detailfast.class);
                int position = holder.getAdapterPosition();
                viewfast news4 = viewfasts.get(position);
                intent4.putExtra("news", news4);
                context.startActivity(intent4);
            }
        });
//        holder.Description.setTag(viewfasts.get(position).getKey());
//        holder.Description.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent( v.getContext(), Detailfast.class);
//                int position = holder.getAdapterPosition();
//                viewfast newsss= viewfasts.get(position);
//                intent3.putExtra("news",newsss);
//                context.startActivity(intent3);
//            }
//        });
    }
// <--set Animation for RecyccleView-->
//
//    private void setAnimation(View itemView, int position) {
//        if(!on_attach){
//            position = -1;
//        }
//        boolean isNotFirstItem = position == -1;
//        position++;
//        itemView.setAlpha(0.f);
//        AnimatorSet animatorSet = new AnimatorSet();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "alpha", 0.f, 0.5f, 1.0f);
//        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
//        animator.setStartDelay(isNotFirstItem ? DURATION / 2 : (position * DURATION / 3));
//        animator.setDuration(50);
//        animatorSet.play(animator);
//        animator.start();
//    }

    @Override
    public int getItemCount() {
        return viewfasts.size();
    }

    static class fastMyViewHolder extends RecyclerView.ViewHolder{
        TextView Header,Time,Source,League;
        ImageView Avatar;
        public  fastMyViewHolder (View itemView) {
            super(itemView);
            Header = (TextView) itemView.findViewById(R.id.idHeader);
            Avatar = (ImageView) itemView.findViewById(R.id.idAvatar);
            Time = (TextView) itemView.findViewById(R.id.idTimefast);
            Source= (TextView) itemView.findViewById(R.id.idSourcefast);
            League = (TextView) itemView.findViewById(R.id.idLeaguefast);
        }
    }

}

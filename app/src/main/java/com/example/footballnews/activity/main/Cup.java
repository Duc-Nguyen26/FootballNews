package com.example.footballnews.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.activity.MainActivity;
import com.example.footballnews.adapter.Cupadapter;
import com.example.footballnews.model.viewcup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Cup extends AppCompatActivity {
    RecyclerView mcup;
    DatabaseReference mdatabase2cup;
    ArrayList<viewcup> viewcups;
    Cupadapter cupadapters;
    Button btback1, bthot1;
    ImageButton ibbxh, iblich, ibbackmain;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cup);
        mcup = (RecyclerView) findViewById(R.id.idREcup);
        mcup.setLayoutManager(new LinearLayoutManager(this));
        viewcups = new ArrayList<viewcup>();
        mdatabase2cup = FirebaseDatabase.getInstance().getReference().child("Cup");
        mdatabase2cup.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    viewcup cup= dataSnapshot1.getValue(viewcup.class);
                    cup.setKey(dataSnapshot1.getKey());
                    viewcups.add(cup);
                }
                cupadapters = new Cupadapter(Cup.this,viewcups);
                mcup.setAdapter(cupadapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Cup.this,"hey hety het hetyhey",Toast.LENGTH_SHORT).show();
            }
        });
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflippercup);
        ActionViewFlipper();
        btback1 = (Button) findViewById(R.id.idfindcup);
        btback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cup.this, find.class);
                startActivity(intent);
            }
        });
        bthot1= (Button) findViewById(R.id.idhotcup);
        bthot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cup.this, hot.class);
                startActivity(intent);
            }
        });
        ibbackmain = (ImageButton) findViewById(R.id.backmaincup);
        ibbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cup.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ibbxh = (ImageButton) findViewById(R.id.bxhcup);
        ibbxh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Cup.this,bxh.class);
                startActivity(intent);
            }
        });
        iblich = (ImageButton) findViewById(R.id.lichcup);
        iblich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cup.this, lich.class);
                startActivity(intent);
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<String> mang = new ArrayList<>();
        mang.add("https://media.ex-cdn.com/EXP/media.giadinhmoi.vn/files/content/2019/12/17/ket-qua-boc-tham-1-8-0837.jpg");
        mang.add("https://media.ex-cdn.com/EXP/media.giadinhmoi.vn/files/content/2019/12/17/ket-qua-boc-tham-1-8-anh2-0846.jpg");
        mang.add("https://static.bongda24h.vn/medias/standard/2019/11/6/ltd-c1-6-11-2019.jpg");
        mang.add("https://cdn.thethao247.vn/upload/cuongnm/2019/12/16/boc-tham-c24.jpg");
        mang.add("https://tttd.ex-cdn.com/files/news/2019/11/08/mu-vao-vong-knock-out-cup-c2-chau-au-2019-2020-071936.jpg");
        for (int i = 0; i<mang.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mang.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slight_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slight_out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slight_out_right);
        viewFlipper.setInAnimation(animation_slight_in);
        viewFlipper.setOutAnimation(animation_slight_out);
    }

}

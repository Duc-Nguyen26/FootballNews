package com.example.footballnews.activity.b24h;

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
import com.example.footballnews.activity.main.bxh;
import com.example.footballnews.activity.main.find;
import com.example.footballnews.activity.main.hot;
import com.example.footballnews.activity.main.lich;
import com.example.footballnews.adapter.b24hadapter;
import com.example.footballnews.model.view24h;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class b24h extends AppCompatActivity {
    RecyclerView m24h;
    DatabaseReference mdatabase24h;
    ArrayList<view24h> view24hs;
    b24hadapter b24hadapters;
    Button btback1, bthot1;
    ImageButton ibbxh, iblich, ibbackmain;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b24h);
        m24h= (RecyclerView) findViewById(R.id.idRE24h);
        m24h.setLayoutManager(new LinearLayoutManager(this));
        view24hs = new ArrayList<view24h>();
        mdatabase24h = FirebaseDatabase.getInstance().getReference().child("b24h");
        mdatabase24h.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    view24h v24h= dataSnapshot1.getValue(view24h.class);
                    v24h.setKey(dataSnapshot1.getKey());
                    view24hs.add(v24h);
                }
                b24hadapters = new b24hadapter(b24h.this,view24hs);
                m24h.setAdapter(b24hadapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(b24h.this,"hey hety het hetyhey",Toast.LENGTH_SHORT).show();
            }
        });
        btback1 = (Button) findViewById(R.id.idfind24);
        btback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(b24h.this, find.class);
                startActivity(intent);
            }
        });
        bthot1= (Button) findViewById(R.id.idhot24);
        bthot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(b24h.this, hot.class);
                startActivity(intent);
            }
        });
        ibbxh = (ImageButton) findViewById(R.id.bxh24h);
        ibbxh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(b24h.this, bxh.class);
                startActivity(intent);
            }
        });
        iblich = (ImageButton) findViewById(R.id.lic24h);
        iblich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(b24h.this, lich.class);
                startActivity(intent);
            }
        });
        ibbackmain = (ImageButton) findViewById(R.id.backmain24h);
        ibbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(b24h.this, MainActivity.class);
                startActivity(intent);
            }
        });
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper24h);
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mang = new ArrayList<>();
        mang.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5COIzyOHPhL1YJyOmNIj7NHpt2mE0f6Ttj7F_j1U-9dJJj34h&s");
        mang.add("https://static.bongda24h.vn/medias/amp/2020/1/13/nhan-dinh-u23-viet-nam-vs-u23-trieu-tien-20h15-ngay-161-giac-mo-co-that.jpg");
        mang.add("https://static.bongda24h.vn/medias/standard/2020/1/16/imgpsh_fullsize_anim-(2).jpg");
        mang.add("https://cdn.24h.com.vn/upload/1-2020/images/2020-01-16/147585619090889-xuan-truong-01-640-1579143460-878-width640height480.jpg");
        mang.add("https://cdn.thethao247.vn/upload/kienlv/2018/12/14/xem-truc-tiep-mu-vs-liverpool-kenh-nao-o-dau1544780210.jpg");
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

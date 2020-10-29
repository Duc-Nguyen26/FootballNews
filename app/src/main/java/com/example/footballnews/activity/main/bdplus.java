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
import com.example.footballnews.adapter.bdplusadapter;
import com.example.footballnews.model.viewbdplus;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class bdplus extends AppCompatActivity {
    RecyclerView mbdplus;
    DatabaseReference mdatabasebdplus;
    ArrayList<viewbdplus> viewbdpluses;
    bdplusadapter bdplusadapters;
    ImageButton iblichbdp,ibbackmain3, ibbxhdbp;
    Button btfind, bthot;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdplus);
        ibbackmain3 =(ImageButton) findViewById(R.id.backmainbdp);
        ibbackmain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bdplus.this, MainActivity.class);
                startActivity(intent);
            }
        });
        iblichbdp = (ImageButton) findViewById(R.id.lichbdp);
        iblichbdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bdplus.this, lich.class);
                startActivity(intent);
            }
        });
        ibbxhdbp= (ImageButton) findViewById(R.id.bxhbdp);
        ibbxhdbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bdplus.this, bxh.class);
                startActivity(intent);
            }
        });
        btfind = (Button) findViewById(R.id.findbdp);
        btfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bdplus.this, find.class);
                startActivity(intent);
            }
        });
        bthot = (Button) findViewById(R.id.hotbdp);
        bthot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bdplus.this, hot.class);
                startActivity(intent);
            }
        });
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipperbdp);
        ActionViewFlipper();

        mbdplus = (RecyclerView) findViewById(R.id.idREbdplus);
        mbdplus.setLayoutManager(new LinearLayoutManager(this));
        viewbdpluses = new ArrayList<viewbdplus>();
        mdatabasebdplus = FirebaseDatabase.getInstance().getReference().child("bplus");
        mdatabasebdplus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot3: dataSnapshot.getChildren())
                {
                    viewbdplus vplus= dataSnapshot3.getValue(viewbdplus.class);
                    vplus.setKey(dataSnapshot3.getKey());
                    viewbdpluses.add(vplus);
                }
                bdplusadapters = new bdplusadapter(bdplus.this,viewbdpluses);
                mbdplus.setAdapter(bdplusadapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(bdplus.this,"hey hety het hetyhey",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ActionViewFlipper() {
        ArrayList<String> mang = new ArrayList<>();
        mang.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjFCeQE0oJhIrjcRmw4Igl-rDMkEYORhP1bDC2als5mJ3CIvdc&s");
        mang.add("http://ibongda.vn/upload/fckeditor/image/2013/THANG%203/19/hienatt/bongdaplus_vn.jpg");
        mang.add("https://cdn.bongdaplus.vn/Assets/Media/2020/01/16/41/chuyen-nhuong1.jpg");
        mang.add("https://cdn.bongdaplus.vn/Assets/Media/2019/10/05/31/park-bbd.jpg");
        mang.add("http://keonhacaipro.com/wp-content/uploads/2019/12/bongdaplus-ltd-bxh-bong-da-bongdaplus-vn-hinh-1.jpg");
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

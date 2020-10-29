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
import com.example.footballnews.adapter.VNadapter;
import com.example.footballnews.model.viewVN;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VN extends AppCompatActivity {
    RecyclerView mVN;
    DatabaseReference mdatabaseVN;
    ArrayList<viewVN> viewVNS;
    VNadapter VNadapters;
    Button btfindvn, bthotvn;
    ImageButton iblichvn, ibbxhvn, ibmainvn;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vn);
        mVN = (RecyclerView) findViewById(R.id.idREVN);
        mVN.setLayoutManager(new LinearLayoutManager(this));
        viewVNS =new  ArrayList<viewVN>();
        mdatabaseVN = FirebaseDatabase.getInstance().getReference().child("VN");
        mdatabaseVN.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2: dataSnapshot.getChildren())
                {
                    viewVN vns = dataSnapshot2.getValue(viewVN.class);
                    vns.setKey(dataSnapshot2.getKey());
                    viewVNS.add(vns);
                }
                VNadapters = new VNadapter(VN.this,viewVNS);
                mVN.setAdapter(VNadapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(VN.this,"hey hety het hetyhey",Toast.LENGTH_SHORT).show();
            }
        });
        btfindvn= (Button) findViewById(R.id.findVN);
        btfindvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VN.this, find.class);
                startActivity(intent);
            }
        });
        bthotvn = (Button) findViewById(R.id.hotVN);
        bthotvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VN.this, hot.class);
                startActivity(intent);
            }
        });
        iblichvn = (ImageButton) findViewById(R.id.lichVN);
        iblichvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VN.this,lich.class);
                startActivity(intent);
            }
        });
        ibbxhvn = (ImageButton) findViewById(R.id.bxhVN);
        ibbxhvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VN.this, bxh.class);
                startActivity(intent);
            }
        });
        ibmainvn = (ImageButton) findViewById(R.id.backmainVN);
        ibmainvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VN.this, MainActivity.class);
                startActivity(intent);
            }
        });
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflippervn);
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao= new ArrayList<>();
        mangquangcao.add("https://znews-photo.zadn.vn/Uploaded/pgi_ubnvgunau/2019_03_27/Cover.jpg");
        mangquangcao.add("https://image.bnews.vn/MediaUpload/Medium/2020/01/15/093930_vck-u23-chau-a-nam-2020-u23-viet-nam-gap-u23-jordan.jpg");
        mangquangcao.add("https://cdn.24h.com.vn/upload/1-2020/images/2020-01-16/U23-Viet-Nam-dau-U23-Trieu-Tien-Talkshow-dac-biet-ve-ban-linh-81605094_769134290274261_4198832626401804288_n-1579138843-870-width660height440.jpg");
        mangquangcao.add("https://baoquocte.vn/stores/news_dataimages/quangdao/122019/09/11/1000_vnvd_wnvo.jpg");
        mangquangcao.add("https://cdn.thethao247.vn/resize_700x400/upload/vanhung/2019/11/20/cac-doi-bat-bai-vl-world-cup-2022-viet-nam-sanh-vai-anh-tai1574219571.jpg");
        for (int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
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

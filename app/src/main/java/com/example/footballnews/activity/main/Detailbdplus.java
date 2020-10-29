package com.example.footballnews.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.footballnews.R;
import com.example.footballnews.activity.MainActivity;
import com.example.footballnews.model.viewbdplus;
import com.squareup.picasso.Picasso;

public class Detailbdplus extends AppCompatActivity {
    private viewbdplus mviewbdplus;
    TextView tvheaderbdplus,tvDetailbdplus;
    ImageView ivbdbplus;
    ImageButton ibbackmain2, ibbackfind2, ibback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbdplus);
        Intent intent = getIntent();
        mviewbdplus= (viewbdplus) intent.getSerializableExtra("bplus");
        tvheaderbdplus = (TextView) findViewById(R.id.idheaderdetailbdplus);
        tvDetailbdplus= (TextView) findViewById(R.id.iddetailbdplus);
        tvDetailbdplus.setMovementMethod(new ScrollingMovementMethod());
        ivbdbplus = (ImageView) findViewById(R.id.idimagedetailplus);
        tvheaderbdplus.setText(mviewbdplus.getHeader());
        Picasso.get().load(mviewbdplus.getImage()).into(ivbdbplus);
        tvDetailbdplus.setText(mviewbdplus.getDetail());
        ibbackfind2= (ImageButton) findViewById(R.id.backfindbdp);
        ibbackfind2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detailbdplus.this,find.class);
                startActivity(intent);
            }
        });
        ibbackmain2 = (ImageButton) findViewById(R.id.backmainbdp);
        ibbackmain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailbdplus.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        ibback2 = (ImageButton) findViewById(R.id.backbdplus);
        ibback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Detailbdplus.this, bdplus.class);
                startActivity(intent2);
            }
        });
    }
}

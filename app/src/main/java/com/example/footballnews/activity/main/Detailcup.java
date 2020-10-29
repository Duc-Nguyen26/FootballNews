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
import com.example.footballnews.model.viewcup;
import com.squareup.picasso.Picasso;

public class Detailcup extends AppCompatActivity {
    private viewcup mviewcup;
    TextView tvheader, tvdetail;
    ImageView ivdetail;
    ImageButton ibbackfind, ibbackmain,ibbackcup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailcup);
        final Intent intent = getIntent();
        mviewcup = (viewcup) intent.getSerializableExtra("cup");
        tvheader = (TextView) findViewById(R.id.idHeadercup);
        tvdetail= (TextView) findViewById(R.id.idDetailcup);
        tvdetail.setMovementMethod(new ScrollingMovementMethod());
        ivdetail = (ImageView) findViewById(R.id.idimagedetailcup);
        tvheader.setText(mviewcup.getHeader());
        Picasso.get().load(mviewcup.getImage()).into(ivdetail);
        tvdetail.setText(mviewcup.getDetail());
        ibbackfind= (ImageButton) findViewById(R.id.backtofindcup);
        ibbackfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailcup.this, find.class);
                startActivity(intent1);
            }
        });
        ibbackmain = (ImageButton) findViewById(R.id.backmaincup);
        ibbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailcup.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        ibbackcup = (ImageButton) findViewById(R.id.backcup);
        ibbackcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(Detailcup.this, Cup.class);
                startActivity(intent1);
            }
        });
    }
}

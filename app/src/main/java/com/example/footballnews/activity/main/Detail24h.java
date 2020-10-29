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
import com.example.footballnews.activity.b24h.b24h;
import com.example.footballnews.model.view24h;
import com.squareup.picasso.Picasso;

public class Detail24h extends AppCompatActivity {
    private view24h mview24hs;
    TextView tvheader24h,tvDetail24h;
    ImageView iv24h;
    ImageButton ibbackmain, ibbackfind, ibback1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail24h);
        Intent intent = getIntent();
        mview24hs= (view24h) intent.getSerializableExtra("b24h");
        tvheader24h = (TextView) findViewById(R.id.idheader24h);
        tvDetail24h= (TextView) findViewById(R.id.iddetail24);
        tvDetail24h.setMovementMethod(new ScrollingMovementMethod());
        iv24h = (ImageView) findViewById(R.id.idimage24h);
        tvheader24h.setText(mview24hs.getHeader());
        Picasso.get().load(mview24hs.getImage()).into(iv24h);
        tvDetail24h.setText(mview24hs.getDetail());
        ibbackfind= (ImageButton) findViewById(R.id.backtofind);
        ibbackfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail24h.this,find.class);
                startActivity(intent);
            }
        });
        ibbackmain = (ImageButton) findViewById(R.id.backmain);
        ibbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detail24h.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        ibback1 = (ImageButton) findViewById(R.id.backb24h);
        ibback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Detail24h.this, b24h.class);
                startActivity(intent2);
            }
        });
    }
}

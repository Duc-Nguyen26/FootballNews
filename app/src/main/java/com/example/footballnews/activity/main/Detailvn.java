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
import com.example.footballnews.model.viewVN;
import com.squareup.picasso.Picasso;

public class Detailvn extends AppCompatActivity {
    private viewVN mviewVN;
    TextView tvheader, tvdetail;
    ImageView iVN;
    ImageButton ibackfind, ibbackVN,ibmainvn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvn);
        Intent intent = getIntent();
        mviewVN= (viewVN) intent.getSerializableExtra("VNS");
        tvheader= (TextView) findViewById(R.id.headervn);
        iVN = (ImageView) findViewById(R.id.imagevn);
        tvdetail = (TextView) findViewById(R.id.Detailvn);
        tvdetail.setMovementMethod(new ScrollingMovementMethod());
        tvheader.setText(mviewVN.getHeader());
        tvdetail.setText(mviewVN.getDetail());
        Picasso.get().load(mviewVN.getImage()).into(iVN);
        ibackfind = (ImageButton) findViewById(R.id.backfindvn);
        ibackfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailvn.this, find.class);
                startActivity(intent1);
            }
        });
        ibbackVN = (ImageButton) findViewById(R.id.backVN);
        ibbackVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailvn.this, VN.class);
                startActivity(intent1);
            }
        });
        ibmainvn = (ImageButton) findViewById(R.id.backmainvn);
        ibmainvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detailvn.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}

package com.example.footballnews.activity.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.footballnews.R;
import com.example.footballnews.model.viewfast;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Detailfast extends AppCompatActivity implements Serializable {
    private viewfast viewfasts;
    TextView tvheader,tvDetail,tvTime,tvSource;
    ImageView ivAvatar1;
    ImageButton ibfind, ibmain, ibback;
    Button  btbackhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailfast);
        Intent intent = getIntent();
        viewfasts= (viewfast)intent.getSerializableExtra("news");
        tvheader = (TextView) findViewById(R.id.idheader);
        tvDetail= (TextView) findViewById(R.id.idDetail1);
        ivAvatar1 = (ImageView) findViewById(R.id.idAvatar1);
        tvTime = (TextView) findViewById(R.id.TimeDetailfast);
        tvSource = (TextView) findViewById(R.id.SourceDetailfast);
        TextView tvdf = (TextView) findViewById(R.id.blinkdf);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font/LCALLIG.TTF");
        tvdf.setTypeface(typeface);
        btbackhome = (Button) findViewById(R.id.idbackhome);
        btbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvheader.setText(viewfasts.getHeader());
        Picasso.get().load(viewfasts.getImage()).into(ivAvatar1);
        tvDetail.setText(viewfasts.getDetail());
        tvTime.setText(viewfasts.getTime());
        tvSource.setText(viewfasts.getSource());
        tvDetail.setMovementMethod(new ScrollingMovementMethod());
        binkdf();
    }

    private void binkdf() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;    //in milissegunds
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView tvdf = (TextView) findViewById(R.id.blinkdf);
                        if(tvdf.getVisibility() == View.VISIBLE){
                            tvdf.setVisibility(View.INVISIBLE);
                        }else{
                            tvdf.setVisibility(View.VISIBLE);
                        }
                        binkdf();
                    }
                });
            }
        }).start();

    }
}

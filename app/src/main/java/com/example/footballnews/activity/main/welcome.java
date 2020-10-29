package com.example.footballnews.activity.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.footballnews.R;
import com.example.footballnews.activity.MainActivity;

public class welcome extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView tvfont = (TextView) findViewById(R.id.idWelcome);
        Typeface typeface = Typeface.createFromAsset(welcome.this.getAssets(), "Font/HARNGTON.TTF");
        tvfont.setTypeface(typeface);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(welcome.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}

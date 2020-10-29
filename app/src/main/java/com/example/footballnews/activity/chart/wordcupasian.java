package com.example.footballnews.activity.chart;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class wordcupasian extends Fragment {
    private View mwordcupasian;
    private WebView webView;
    private Button url;
    private FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference reference = databaseReference.child("Match").child("Match1").child("url");


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mwordcupasian = inflater.inflate(R.layout.activity_wordcupasian, container, false);
        webView = (WebView) mwordcupasian.findViewById(R.id.wvwwca);
        url = (Button) mwordcupasian.findViewById(R.id.url);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebChromeClient(new WebChromeClient());
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String video = snapshot.getValue(String.class);
                        Intent i = new Intent(Intent.ACTION_VIEW);
//                        url.setText(video);
                        i.setData(Uri.parse(video));
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Font/BRUSHSCI.TTF");
//        tvfont.setTypeface(typeface);

        return mwordcupasian;

    }

}


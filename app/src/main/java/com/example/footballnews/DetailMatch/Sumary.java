package com.example.footballnews.DetailMatch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.example.footballnews.model.viewmatch;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Sumary extends Fragment implements Serializable {
    private  View mSumary;
    private viewmatch viewmatchs;
    Button imageButton;
//    private  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = firebaseDatabase.getReference();
//    private DatabaseReference videoreference = databaseReference.child("url");
    TextView tvgoal1, tvgoal2,tvsumary1, tvsumary2, tvtimesmr, tvsoursmr;
    ImageView ivteam11, ivteam22, ivsumary;
    private  int possition = 0;
    private Uri uri;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState) {
        mSumary = inflater.inflate(R.layout.activity_sumary, container, false);
        imageButton= (Button) mSumary.findViewById(R.id.idvdsumary);
        tvgoal1 = (TextView) mSumary.findViewById(R.id.idplayscore1);
        tvgoal2 = (TextView) mSumary.findViewById(R.id.idplayscore2);
        tvsumary1 = (TextView) mSumary.findViewById(R.id.idtvsumary1);
        tvsumary2 = (TextView) mSumary.findViewById(R.id.idtvsumary2);
        tvtimesmr = (TextView) mSumary.findViewById(R.id.idtimesumary);
        tvsoursmr = (TextView) mSumary.findViewById(R.id.idsourcesumary);
        ivteam11 = (ImageView) mSumary.findViewById(R.id.idivTeam11);
        ivteam22 = (ImageView) mSumary.findViewById(R.id.idivTeam22);
        ivsumary =  (ImageView) mSumary.findViewById(R.id.ivsumary);
//        MediaController mediaController = new MediaController(getContext());
//        mediaController.setAnchorView(videoView);
        Intent intentsmr = getActivity().getIntent();
        viewmatchs = (viewmatch) intentsmr.getSerializableExtra("Match");
        tvgoal1.setText(viewmatchs.getGoal1());
        tvgoal2.setText(viewmatchs.getGoal2());
        tvsumary1.setText(viewmatchs.getSumary1());
        tvsumary2.setText(viewmatchs.getSumary2());
        tvtimesmr.setText(viewmatchs.getTimesumary());
        tvsoursmr.setText(viewmatchs.getSource());
        Picasso.get().load(viewmatchs.getTeam1()).into(ivteam11);
        Picasso.get().load(viewmatchs.getTeam2()).into(ivteam22);
        Picasso.get().load(viewmatchs.getImageSumary()).into(ivsumary);
        imageButton.setTag(viewmatchs.getUrl());
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String video = v.toString();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(video));
                startActivity(i);
            }
        });
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(Uri.parse(viewmatchs.getVideo()));
//        videoView.setVideoPath("")
//        String videopath = "android.resource://com.example.footballnews.DetailMatch/"+R.raw.mu;
//        Uri uri = Uri.parse(videopath);
//        videoView.setVideoURI(Uri.parse("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
//        videoView.requestFocus();
//        videoView.start();
        return mSumary;

        }

}
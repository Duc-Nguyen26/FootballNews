package com.example.footballnews.DetailMatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.example.footballnews.model.viewmatch;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Lineup1 extends Fragment implements Serializable {
private View mlineup1;
private viewmatch viewmatchln;
ImageView ivteamln1, ivlineup1, ivdubi1, ivstarting1;
TextView tvlineup1, tvcoach1, tvviewln1;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mlineup1 = inflater.inflate(R.layout.activity_lineup1, container, false);
        Intent intentln1 = getActivity().getIntent();
        viewmatchln = (viewmatch) intentln1.getSerializableExtra("Match");
        ivteamln1 = (ImageView) mlineup1.findViewById(R.id.idlnteam1);
        ivlineup1 = (ImageView) mlineup1.findViewById(R.id.idivlineup1);
        ivdubi1 = (ImageView) mlineup1.findViewById(R.id.ivdubi1);
        ivstarting1 = (ImageView) mlineup1.findViewById(R.id.ivstarting1);
        tvlineup1 = (TextView) mlineup1.findViewById(R.id.idtvlineup1);
        tvcoach1 = (TextView) mlineup1.findViewById(R.id.idhlvln1);
        tvviewln1 = (TextView) mlineup1.findViewById(R.id.tvviewln1);
        tvlineup1.setText(viewmatchln.getLineup1());
        tvcoach1.setText(viewmatchln.getCoach1());
        tvviewln1.setText(viewmatchln.getViewline1());
        Picasso.get().load(viewmatchln.getTeam1()).into(ivteamln1);
        Picasso.get().load(viewmatchln.getImageLineup1()).into(ivlineup1);
        Picasso.get().load(viewmatchln.getSubition1()).into(ivdubi1);
        Picasso.get().load(viewmatchln.getStarting1()).into(ivstarting1);
        return mlineup1;
    }
}

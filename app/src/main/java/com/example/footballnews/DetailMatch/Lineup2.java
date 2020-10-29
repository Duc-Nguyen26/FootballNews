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

public class Lineup2 extends Fragment implements Serializable {
    private View mlineup2;
    private viewmatch viewmatchln;
    ImageView ivteamln2, ivlineup2, ivdubi2, ivstarting2;
    TextView tvlineup2, tvcoach2, tvviewln2;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mlineup2 = inflater.inflate(R.layout.activity_lineup2, container, false);
        Intent intentln2 = getActivity().getIntent();
        viewmatchln = (viewmatch) intentln2.getSerializableExtra("Match");
        ivteamln2 = (ImageView) mlineup2.findViewById(R.id.idlnteam2);
        ivlineup2 = (ImageView) mlineup2.findViewById(R.id.idivlineup2);
        ivstarting2 = (ImageView) mlineup2.findViewById(R.id.ivstarting2);
        ivdubi2 = (ImageView) mlineup2.findViewById(R.id.ivdubi2);
        tvlineup2 = (TextView) mlineup2.findViewById(R.id.idtvlineup2);
        tvcoach2 = (TextView) mlineup2.findViewById(R.id.idhlvln2);
        tvviewln2 = (TextView) mlineup2.findViewById(R.id.tvviewln2);
        tvlineup2.setText(viewmatchln.getLineup2());
        tvcoach2.setText(viewmatchln.getCoach2());
        tvviewln2.setText(viewmatchln.getViewline2());
        Picasso.get().load(viewmatchln.getTeam2()).into(ivteamln2);
        Picasso.get().load(viewmatchln.getImageLineup2()).into(ivlineup2);
        Picasso.get().load(viewmatchln.getStarting2()).into(ivstarting2);
        Picasso.get().load(viewmatchln.getSubition2()).into(ivdubi2);
        return mlineup2;
    }
}

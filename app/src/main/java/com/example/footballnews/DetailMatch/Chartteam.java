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

import java.io.Serializable;

public class Chartteam extends Fragment implements Serializable {
    private View mChartteam;
    private viewmatch viewmatchidetail;
    ImageView ivaftetmatch, ivviewline1, ivviewline2;
    TextView tvaftermatch, ivview1, ivview2;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mChartteam = inflater.inflate(R.layout.activity_chartteam, container, false);
        Intent intentid = getActivity().getIntent();
        viewmatchidetail = (viewmatch) intentid.getSerializableExtra("Match");
        ivaftetmatch = (ImageView) mChartteam.findViewById(R.id.idimageafterchart);
        ivviewline1 = (ImageView) mChartteam.findViewById(R.id.ivlinechart1);
        ivviewline2 = (ImageView) mChartteam.findViewById(R.id.ivlinechart2);
        tvaftermatch = (TextView) mChartteam.findViewById(R.id.idviewafterchart);
        ivview1 = (TextView) mChartteam.findViewById(R.id.idviewline1);
        ivview2 = (TextView) mChartteam.findViewById(R.id.idviewline2);
        return mChartteam;
    }
}

package com.example.footballnews.DetailMatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.footballnews.R;
import com.example.footballnews.adapter.lineupfragment;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

public class Lineup extends Fragment implements Serializable {
    private View mlineup;
    private TabLayout tabLayoutln;
    private ViewPager viewPagerln;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mlineup = inflater.inflate(R.layout.activity_lineup, container, false);
        tabLayoutln = (TabLayout) mlineup.findViewById(R.id.tblineup);
        viewPagerln = (ViewPager) mlineup.findViewById(R.id.vplineup);
        actionln();
        return mlineup;
    }

    private void actionln() {
        viewPagerln.setAdapter(new lineupfragment(getActivity().getSupportFragmentManager()));
        tabLayoutln.setupWithViewPager(viewPagerln);
        return ;
    }

}

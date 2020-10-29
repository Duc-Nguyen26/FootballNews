package com.example.footballnews.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.footballnews.activity.chart.england;
import com.example.footballnews.activity.chart.france;
import com.example.footballnews.activity.chart.germany;
import com.example.footballnews.activity.chart.italia;
import com.example.footballnews.activity.chart.spain;
import com.example.footballnews.activity.chart.wordcupasian;

public class BxhFragment extends FragmentStatePagerAdapter {
        private String listTab[] = {"WordCup Asian","England","Spain","Germany","Italia","France"};
    private wordcupasian mwordcupasian = new wordcupasian();
    private england mengland = new england();
    private spain mspain = new spain();
    private italia mitalia = new italia();
    private germany mgermany = new germany();
    private france mfrance = new france();
    public BxhFragment (FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
         if (position ==0 ){
            return  mwordcupasian;
        }else if(position ==1){
            return mengland;
        }else if (position ==2){
            return mspain;
        }else if (position==3){
            return  mgermany;
        }else if(position==4){
            return mitalia;
        }else if(position==5)
            return  mfrance;
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}

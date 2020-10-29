package com.example.footballnews.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.footballnews.DetailMatch.Lineup1;
import com.example.footballnews.DetailMatch.Lineup2;

public class lineupfragment extends FragmentStatePagerAdapter {
    private String listTab[] = {"HOME","AWAY"};
    private Lineup1 lineup1 = new Lineup1();
    private Lineup2 lineup2 = new Lineup2();
    public lineupfragment(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position ==0 ){
            return lineup1;
        }else if(position ==1){
            return lineup2;
        }
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

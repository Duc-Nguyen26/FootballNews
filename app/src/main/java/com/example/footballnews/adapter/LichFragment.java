package com.example.footballnews.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.footballnews.activity.lich.Day;
import com.example.footballnews.activity.lich.week;

public class LichFragment extends FragmentStatePagerAdapter {
    private String listTab[] = {"Day","Week"};
    private Day day = new Day();
    private week week  = new week();
    public LichFragment(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position ==0 ){
            return day;
        }else if(position ==1){
            return week;
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

package com.example.footballnews.activity.lich;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;

public class week extends Fragment {
    private View mweek;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mweek= inflater.inflate(R.layout.activity_week, container, false);
        return mweek;
    }
}

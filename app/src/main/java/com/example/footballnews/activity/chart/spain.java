package com.example.footballnews.activity.chart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.footballnews.R;

public class spain extends Fragment {
    private View mspain;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mspain = inflater.inflate(R.layout.activity_spain, container, false);
        return mspain;
    }
}

package com.example.footballnews.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;

public class notification extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstantState) {
        View mnotifi = inflater.inflate(R.layout.activity_notification, container, false);
        return mnotifi;
    }
}

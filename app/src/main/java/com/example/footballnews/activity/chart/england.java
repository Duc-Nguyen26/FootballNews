package com.example.footballnews.activity.chart;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.example.footballnews.activity.User.Resetpassword;


public class england extends Fragment {
    private View mengland;
    Button btbackendland;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mengland = inflater.inflate(R.layout.activity_england, container, false);
        TextView tvendland = (TextView) mengland.findViewById(R.id.idtvengland);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Font/CASTELAR.TTF");
        tvendland.setTypeface(typeface);
        btbackendland = (Button) mengland.findViewById(R.id.idbtbackengland);
        btbackendland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Resetpassword.class);
                startActivity(intent);
            }
        });
        return mengland;
    }
}

package com.example.footballnews.activity.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.footballnews.R;
import com.example.footballnews.activity.chart.england;
import com.example.footballnews.activity.chart.france;
import com.example.footballnews.activity.chart.germany;
import com.example.footballnews.activity.chart.italia;
import com.example.footballnews.activity.chart.spain;
import com.example.footballnews.adapter.BxhFragment;
import com.example.footballnews.adapter.selectbxhadapter;
import com.example.footballnews.model.viewselectbxh;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bxh extends Fragment {
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    TextView tvbxh;
    Button btmenubxh;
    RecyclerView mslbxh;
    DatabaseReference mdatabaseslbxh;
    ArrayList<viewselectbxh> viewselectbxhs;
    selectbxhadapter selectbxhadapters;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        View view = inflater.inflate(R.layout.activity_bxh, container, false);
        btmenubxh = (Button) view.findViewById(R.id.idbtppmenubxh);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpagerbxh);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayoutbxh);
        tvbxh = (TextView) view.findViewById(R.id.idtvbxh);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Font/GIGI.TTF");
        tvbxh.setTypeface(typeface);
        btmenubxh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmenu();
            }

            private void showmenu() {
                PopupMenu popupMenu = new PopupMenu(getContext(),btmenubxh);
                popupMenu.getMenuInflater().inflate(R.menu.popuplich, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.idengland:
                                startActivity(new Intent(getContext(), england.class));
                                break;
                            case R.id.idfrance:
                                startActivity(new Intent(getContext(), france.class));
                                break;
                            case R.id.iditalia:
                                startActivity(new Intent(getContext(), italia.class));
                                break;
                            case R.id.idgermarny:
                                startActivity(new Intent(getContext(), germany.class));
                                break;
                            case R.id.idspain:
                                startActivity(new Intent(getContext(), spain.class));
                                break;
                            case R.id.idcup:
                                startActivity(new Intent(getContext(), england.class));
                                break;
                            case R.id.idbongdavietnam:
                                startActivity(new Intent(getContext(), england.class));
                                break;
                        }
                        return false;

                    }
                });
                popupMenu.show();
            }
        });
        mslbxh = (RecyclerView) view.findViewById(R.id.idREselectbxh);
        mslbxh.setLayoutManager(new LinearLayoutManager(getContext()));
        viewselectbxhs = new ArrayList<viewselectbxh>();
        mdatabaseslbxh = FirebaseDatabase.getInstance().getReference().child("SLbxh");
        mdatabaseslbxh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    viewselectbxh vs = dataSnapshot1.getValue(viewselectbxh.class);
                    viewselectbxhs.add(vs);
                }
                selectbxhadapters = new selectbxhadapter(getContext(), viewselectbxhs);
                mslbxh.setAdapter(selectbxhadapters);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mslbxh.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        initView();
        return view;
    }

    private Void  initView() {
        mViewPager.setAdapter(new BxhFragment(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(mViewPager);
        return null;
    }
}

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
import com.example.footballnews.activity.token;
import com.example.footballnews.adapter.LichFragment;
import com.example.footballnews.adapter.selectbxhadapter;
import com.example.footballnews.model.viewselectbxh;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class lich extends Fragment {
    private ViewPager viewPagerlich;
    private TabLayout tabLayoutlich;
    TextView tvlich, tvDaylich;
    Button btppmenu;
    RecyclerView mselect;
    DatabaseReference mdatabaseslbxh;
    ArrayList<viewselectbxh> viewselectbxhs;
    selectbxhadapter selectbxhadapters;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        View mlich = inflater.inflate(R.layout.activity_lich, container, false);
        btppmenu = (Button) mlich.findViewById(R.id.idbtppmenulich);
        mselect = (RecyclerView) mlich.findViewById(R.id.idREselectlich);
        btppmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();
            }

            private void popupMenu() {
                PopupMenu popupMenu = new PopupMenu(getContext(),btppmenu);
                popupMenu.getMenuInflater().inflate(R.menu.popuplich, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.idengland:
                                startActivity(new Intent(getContext(), token.class));
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
        mselect.setLayoutManager(new LinearLayoutManager(getContext()));
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
                mselect.setAdapter(selectbxhadapters);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mselect.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        viewPagerlich = (ViewPager) mlich.findViewById(R.id.viewpagerlich);
        tabLayoutlich = (TabLayout) mlich.findViewById(R.id.TabLayoutlich);
        tvlich  = (TextView) mlich.findViewById(R.id.idtvlich);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Font/CHILLER.TTF");
        tvlich.setTypeface(typeface);
        actionview();
        return mlich;
    }
    private Void actionview() {
        viewPagerlich.setAdapter(new LichFragment(getActivity().getSupportFragmentManager()));
        tabLayoutlich.setupWithViewPager(viewPagerlich);
        return null;
    }
}

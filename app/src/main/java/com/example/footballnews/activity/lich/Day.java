package com.example.footballnews.activity.lich;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.adapter.lichdayadapter;
import com.example.footballnews.adapter.lichtomorrowadapter;
import com.example.footballnews.model.viewlichday;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Day extends Fragment {
    private View mday;
    DatabaseReference databaselichday, databasetomorrow;
    RecyclerView mlichday, mtomorrow;
    ArrayList<viewlichday> viewlichdays;
    ArrayList<viewlichday> viewtomorrows;
    lichdayadapter lichdayadapters;
    lichtomorrowadapter lichtomorrowadapters;
    FirebaseRecyclerAdapter<viewlichday, lichdayadapter.MyViewHolder> adapterday;
    FirebaseRecyclerOptions<viewlichday> options;
    EditText edlich;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mday= inflater.inflate(R.layout.activity_day, container, false);
        mlichday = (RecyclerView) mday.findViewById(R.id.idRELichday);
        edlich = (EditText) mday.findViewById(R.id.idsearchlich);
        edlich.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    search(s.toString());
                }
                else {
                    search("");
                }
            }
        });
        mlichday.setLayoutManager(new LinearLayoutManager(getContext()));
        viewlichdays = new ArrayList<viewlichday>();
        databaselichday = FirebaseDatabase.getInstance().getReference().child("Lich").child("Day").child("Today");
        databaselichday.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    viewlichday vld = dataSnapshot1.getValue(viewlichday.class);
                    viewlichdays.add(vld);
                }
                lichdayadapters = new lichdayadapter(getContext(), viewlichdays);
                mlichday.setAdapter(lichdayadapters);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
                mlichday.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mtomorrow = (RecyclerView) mday.findViewById(R.id.idREtomorrow);
        mtomorrow.setLayoutManager(new LinearLayoutManager(getContext()));
        viewtomorrows = new ArrayList<viewlichday>();
        databasetomorrow = FirebaseDatabase.getInstance().getReference().child("Lich").child("Day").child("Tomorrow");
        databasetomorrow.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()){
                 viewlichday vtmo = dataSnapshot2.getValue(viewlichday.class);
                 viewtomorrows.add(vtmo);
                }
                lichtomorrowadapters = new lichtomorrowadapter(getContext(), viewtomorrows);
                mtomorrow.setAdapter(lichtomorrowadapters);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
                mtomorrow.setLayoutManager(linearLayoutManager);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return mday;
    }

    private void search(String s) {
        Query query = databaselichday.orderByChild("League").startAt(s).endAt(s + "\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    viewlichdays.clear();
                    for (DataSnapshot dld: dataSnapshot.getChildren())
                    {
                        final viewlichday viewlichday1 = dld.getValue(viewlichday.class);
                        viewlichdays.add(viewlichday1);
                    }
                    lichdayadapter lichdayadapter1 = new lichdayadapter(getContext(),viewlichdays);
                    mlichday.setAdapter(lichdayadapter1);
                    lichdayadapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query query1 = databaselichday.orderByChild("League").startAt(s).endAt(s + "\uf8ff");
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    viewlichdays.clear();
                    for(DataSnapshot dtm: dataSnapshot.getChildren())
                    {
                        final  viewlichday viewlichday2 = dtm.getValue(viewlichday.class);
                        viewlichdays.add(viewlichday2);
                    }
                    lichtomorrowadapter lichtomorrowadapter1 = new lichtomorrowadapter(getContext(),viewlichdays);
                    mtomorrow.setAdapter(lichtomorrowadapter1);
                    lichtomorrowadapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

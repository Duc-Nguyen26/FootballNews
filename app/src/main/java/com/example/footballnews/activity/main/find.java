package com.example.footballnews.activity.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.adapter.fastadapter;
import com.example.footballnews.adapter.relatedadapter;
import com.example.footballnews.model.viewRelated;
import com.example.footballnews.model.viewfast;
import com.example.footballnews.model.viewsearch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class find extends AppCompatActivity {
    Button btback,btcheck;
    EditText svsearch;
    RecyclerView rcresultsearchfast, rcresultsearchfast2 ,rcresultsearchfast3;
    DatabaseReference databaseReference;
    ArrayList<viewsearch> viewsearchArrayList;
    ArrayList<viewfast> viewfasts;
    ArrayList<viewRelated> viewRelateds;
    fastadapter fastadapter;
    relatedadapter relatedadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        btback = (Button) findViewById(R.id.idbackfast);
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btcheck = (Button) findViewById(R.id.idcheckboxfind);
        btcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
            private void showMenu() {
                                           PopupMenu popupMenu = new PopupMenu(find.this, btcheck);
                                           popupMenu.getMenuInflater().inflate(R.menu.find, popupMenu.getMenu());
                                           popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                               @Override
                                               public boolean onMenuItemClick(MenuItem item) {
                                                   switch (item.getItemId()) {
                                                       case R.id.idTinhnhanh:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("Fast");
                                                           break;
                                                       case R.id.idtinvang:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("Hot");
                                                           break;
                                                       case R.id.idTinbenle:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("Fasthot");
                                                           break;
                                                       case R.id.idCup:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("Cup");
                                                           break;
                                                       case R.id.idbongdavietnam:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("VN");
                                                           break;
                                                       case R.id.idDoibong:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("SLbxh");
                                                           break;
                                                       case R.id.idbao24h:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("b24h");
                                                           break;
                                                       case R.id.idbaobongdaplus:
                                                           databaseReference = FirebaseDatabase.getInstance().getReference().child("bplus");
                                                           break;
                                                   }
                                                   return false;

                                               }
                                           });
                                           popupMenu.show();
                                       }
        });

        rcresultsearchfast = (RecyclerView) findViewById(R.id.resultfindfast);
        svsearch = (EditText) findViewById(R.id.idsearchview);
        svsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    searchdata(s.toString());
                    return;
                }
                else {
                    searchdata("");
                }
            }
        });
        viewfasts = new ArrayList<viewfast>();
        rcresultsearchfast.setLayoutManager(new LinearLayoutManager(this));
        rcresultsearchfast.setHasFixedSize(true);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Fast");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                     viewfast vf = dataSnapshot1.getValue(viewfast.class);
                    viewfasts.add(vf);
                }

                fastadapter = new fastadapter(find.this,viewfasts);
                rcresultsearchfast.setAdapter(fastadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

////////    private void ActionViewFlipper() {
////////        ArrayList<String> mang= new ArrayList<>();
//////        mang.add("https://cuoifly.tuoitre.vn/605/0/ttc/r/2019/12/23/ban-thang-cau-vong-tuyet-cua-quang-hai-u23-chau-a-1577099848.jpg");
////        mang.add("https://photo-3-baomoi.zadn.vn/w1000_r1m/2018_01_15_274_24627464/12b23fbdfcfb15a54cea.jpg");
////        mang.add("https://znews-photo.zadn.vn/w660/Uploaded/izhmr/2014_12_06/44.jpg");
////        mang.add("https://cdnmedia.thethaovanhoa.vn/2012/11/23/16/05/90Wengertrieutap4cauthuHAGL1.jpg");
////        mang.add("https://photo-2-baomoi.zadn.vn/w1000_r1/2019_01_31_65_29538511/a3d576c9f5881cd64599.jpg");
////        mang.add("https://photo-2-baomoi.zadn.vn/w1000_r1/2019_01_30_65_29528026/93eccb321773fe2da762.jpg");
////        for (int i = 0; i<mang.size(); i++) {
////            ImageView imageView = new ImageView(getApplicationContext());
////            Picasso.get().load(mang.get(i)).into(imageView);
////            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
////            viewFlipper.addView(imageView);
////        }
////        viewFlipper.setFlipInterval(5000);
////        viewFlipper.setAutoStart(true);
////        Animation animation_slight_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
////        Animation animation_slight_out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slight_out_right);
////        viewFlipper.setInAnimation(animation_slight_in);
////        viewFlipper.setOutAnimation(animation_slight_out);
////    }
//
//    }
//

    }

    private void searchdata(final String s) {
        Query query1 = databaseReference.orderByChild("Header").startAt(s).endAt(s + "\uf8ff");
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    viewfasts.clear();
                    for (DataSnapshot dsv: dataSnapshot.getChildren()){
                        final viewfast viewfast1 = dsv.getValue(viewfast.class);
                        viewfasts.add(viewfast1);
                    }
                    fastadapter fastadapter1 = new fastadapter(find.this, viewfasts);
                    rcresultsearchfast.setAdapter(fastadapter1);
                    fastadapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Query query21 = databaseReference.orderByChild("League").startAt(s).endAt(s + "\uf8ff");
        query21.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    viewfasts.clear();
                    for (DataSnapshot dsv1: dataSnapshot.getChildren()){
                        final  viewfast viewfast2 = dsv1.getValue(viewfast.class);
                        viewfasts.add(viewfast2);
                    }
                    fastadapter fastadapter2 = new fastadapter(find.this, viewfasts);
                    rcresultsearchfast.setAdapter(fastadapter2);

                    fastadapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

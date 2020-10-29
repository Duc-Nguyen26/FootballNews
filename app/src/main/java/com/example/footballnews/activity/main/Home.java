package com.example.footballnews.activity.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballnews.R;
import com.example.footballnews.adapter.fastadapter;
import com.example.footballnews.adapter.matchadapter;
import com.example.footballnews.adapter.relatedadapter;
import com.example.footballnews.model.RecyclerDecoration;
import com.example.footballnews.model.viewRelated;
import com.example.footballnews.model.viewfast;
import com.example.footballnews.model.viewmatch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends Fragment {
    RecyclerView mFast,mmatch, mrelared;
    DatabaseReference mdatabase, mdatabasematch, mdatabaserelated;
    ArrayList<viewfast> viewfasts;
    ArrayList<viewmatch> viewmatches;
    ArrayList<viewRelated> viewRelateds;
    fastadapter fastadapters;
    matchadapter matchadapters;
    relatedadapter relatedadapters;
    TextView tvresult;
     Button btfind, bthot;
    public static final String TAG = "MyTag";
    ViewFlipper viewFlipper;
//    float startX;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstantState) {
        final View mhome = inflater.inflate(R.layout.activity_home, container, false);
        final TextView tvfont = (TextView) mhome.findViewById(R.id.idFBN);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Font/LCALLIG.TTF");
        tvfont.setTypeface(typeface);
//        TextView tvfont1 = (TextView) mhome.findViewById(R.id.idHeader);
//        Typeface typeface1 = Typeface.createFromAsset(getContext().getAssets(),"Font/BRUSHSCI.TTF");
//        tvfont1.setTypeface(typeface1);
        btfind = (Button) mhome.findViewById(R.id.idfind);
        btfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), find.class);
                startActivity(intent);
            }
        });


        mrelared= (RecyclerView) mhome.findViewById(R.id.idtinvang);
        mrelared.setLayoutManager(new LinearLayoutManager(getContext()));
        viewRelateds = new ArrayList<viewRelated>();
        mdatabaserelated = FirebaseDatabase.getInstance().getReference().child("Fasthot");
        mdatabaserelated.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()){
                    viewRelated vr = dataSnapshot2.getValue(viewRelated.class);
                    vr.setKey(dataSnapshot2.getKey());
                    viewRelateds.add(vr);
                }
                relatedadapters = new relatedadapter(getContext(), viewRelateds);
                mrelared.setAdapter(relatedadapters);
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
                mrelared.setLayoutManager(linearLayoutManager2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mFast = (RecyclerView) mhome.findViewById(R.id.idRE);
        mFast.setLayoutManager(new LinearLayoutManager(getContext()));
        viewfasts = new ArrayList<viewfast>();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Fast");
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    viewfast vf = dataSnapshot1.getValue(viewfast.class);
                    vf.setKey(dataSnapshot1.getKey());
                    viewfasts.add(vf);
                }
                fastadapters = new fastadapter(getContext(), viewfasts);
                mFast.setAdapter(fastadapters);

//               <--RecyclerView Scroll Vertical-->
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                mFast.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        int sidePadding = getResources().getDimensionPixelSize(R.dimen.sidePadding);
        int topPadding = getResources().getDimensionPixelSize(R.dimen.topPadding);
        mFast.addItemDecoration(new RecyclerDecoration(sidePadding, topPadding));

        mmatch = (RecyclerView) mhome.findViewById(R.id.idReMatch);
        mmatch.setLayoutManager(new LinearLayoutManager(getContext()));
        viewmatches = new ArrayList<viewmatch>();
        mdatabasematch =FirebaseDatabase.getInstance().getReference().child("Match");
        mdatabasematch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    viewmatch vm = dataSnapshot1.getValue(viewmatch.class);
                    vm.setKey(dataSnapshot1.getKey());
                    viewmatches.add(vm);
                }
                matchadapters = new matchadapter(getContext(), viewmatches);
                mmatch.setAdapter(matchadapters);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mmatch.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final int blink = 1200;
                try {Thread.sleep(blink);} catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvresult = (TextView) mhome.findViewById(R.id.idtvResultMatch);
                         if(tvresult.getVisibility() == View.VISIBLE){
                            tvresult.setVisibility(View.VISIBLE);
                        }else {
                            tvresult.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }).start();
//        viewFlipper = (ViewFlipper) mhome.findViewById(R.id.idvf);
//        ActionViewFlipper();
      return mhome;
    //    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        usingFirebaseDatabase();
//    }

//    private void usingFirebaseDatabase() {
//        mdatabasefn = FirebaseDatabase.getInstance().getReference().child("Fasthot");
//        mdatabasefn.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    viewnewfasts.clear();
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        viewnewfast model = snapshot.getValue(viewnewfast.class);
//
//                        viewnewfasts.add(model);
//                    }
//                    usingFirebaseImages(viewnewfasts);
//                } else {
//                    Toast.makeText(getActivity(), "No images in firebase", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(getActivity(), "NO images found \n" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


//    private void usingFirebaseImages(ArrayList<viewnewfast> viewnewfasts) {
//        for (int i = 0; i<viewnewfasts.size(); i++){
//            String dowloadImageUrl = viewnewfasts.get(i).getImage();
//            flipImages(dowloadImageUrl);
//        }
//    }
//
//    @SuppressLint("ClickableViewAccessibility")
//    private void flipImages(String imageUrl) {
//        ImageView imageView = new ImageView(getActivity());
//        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        viewFlipper.addView(imageView);
//        Animation animation_slight_in= AnimationUtils.loadAnimation(getContext().getApplicationContext(),R.anim.slide_in_right);
//        Animation animation_slight_out=AnimationUtils.loadAnimation(getContext().getApplicationContext(),R.anim.slight_out_right);
//        animation_slight_in.setDuration(700);
//        animation_slight_out.setDuration(700);
//        viewFlipper.startFlipping();
//        viewFlipper.setAutoStart(true);
//        viewFlipper.setFlipInterval(5000);
//        viewFlipper.setInAnimation(animation_slight_in);
//        viewFlipper.setOutAnimation(animation_slight_out);
//        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getActionMasked();
//
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        startX = event.getX();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        float endX = event.getX();
//                        float endY = event.getX();
//
//                        //swipe right
//                        if (startX < endX) {
//                            Home.this.viewFlipper.showNext();
//                        }
//
//                        //swipe left
//                        if (startX > endY) {
//                            Home.this.viewFlipper.showPrevious();
//                        }
//
//                        break;
//                }
//                return true;
//            }
//        });
//   }
    }





//    private void ActionViewFlipper() {
//        ArrayList<String> quangcao = new ArrayList<>();
//
//        quangcao.add("https://i.pinimg.com/originals/32/c6/f8/32c6f84260c13a40cc5beb15f279849e.jpg");
//        quangcao.add("https://i.pinimg.com/236x/ff/1c/83/ff1c831e30c2bb5d5908e988cbe264a6.jpg");
//        quangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQrZlsuh_x4L1P6PW5VOxSBIPG6MDv3h2XPQ-RN2veT8Ao0rQZh");
//        quangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQPV6aLWONVHFZG2QJ9h0UmBTKGgdF67tpn9UttbUD8h1l-FQQg");
//        quangcao.add("https://i.pinimg.com/236x/03/4e/c4/034ec4aeaa73dfcd47210a192a3f2705.jpg");
//        quangcao.add("https://i.pinimg.com/originals/32/de/77/32de77f2336e5adb20b3fbf58d13d94a.jpg");
//        quangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQTvKbEYNK8VLgaf9ud9iQU1mdTPFsMfX13LzhjUoBN43XlC9kv");
//        quangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQfe47KIlYCGQGRZDYdqdEIZ9MHbeGGG9yIETNWmx6ASQBuIk2_");
//        quangcao.add("https://i.pinimg.com/236x/a2/c2/16/a2c216bd889ae6303c5055f77df729d7.jpg");
//        quangcao.add("https://i.pinimg.com/236x/47/5c/14/475c1411a05b614a8a5f97647ce869c9.jpg");
//        for (int i=0; i<quangcao.size(); i++){
//            ImageView imageView = new ImageView(getContext().getApplicationContext());
//            Picasso.get().load(quangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//        Animation animation_slight_in= AnimationUtils.loadAnimation(getContext().getApplicationContext(),R.anim.slide_in_right);
//        Animation animation_slight_out=AnimationUtils.loadAnimation(getContext().getApplicationContext(),R.anim.slight_out_right);
//        animation_slight_in.setDuration(700);
//        animation_slight_out.setDuration(700);
//        viewFlipper.startFlipping();
//        viewFlipper.setAutoStart(true);
//        viewFlipper.setFlipInterval(2200);
//        viewFlipper.setInAnimation(animation_slight_in);
//        viewFlipper.setOutAnimation(animation_slight_out);
//    }
}

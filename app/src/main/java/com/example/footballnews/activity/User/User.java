package com.example.footballnews.activity.User;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.example.footballnews.model.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User extends Fragment {
Button bttodtm,bttoregister, tvtoprofile,btlogout;
 VideoView videoView;
TextView edname, edemail ,edgender, edlocation;
FirebaseAuth mAuthuser;
FirebaseUser firebaseUser;
FirebaseDatabase firebaseuser;
DatabaseReference databaseuser;
//    private static  final String USER = "users";
//    private static  final String TAG = "User";
    private String email;
    private Users users;
private Uri uri1;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        View mUser = inflater.inflate(R.layout.activity_user, container, false);
        Intent intent = getActivity().getIntent();
        email = intent.getStringExtra("email");
       tvtoprofile = (Button) mUser.findViewById(R.id.idtoprofile);
       btlogout = (Button) mUser.findViewById(R.id.btdangxuat);
       edname = (TextView) mUser.findViewById(R.id.nameuser);
       edemail = (TextView) mUser.findViewById(R.id.emailuser);
       edgender = (TextView) mUser.findViewById(R.id.genderuser);
       edlocation = (TextView) mUser.findViewById(R.id.locationuser);
        tvtoprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Resetpassword.class));
            }
        });
        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Resetpassword.class));
            }
        });
//       firebaseuser = FirebaseDatabase.getInstance();
//       databaseuser = firebaseuser.getReference(USER);
//
//
//           final String email = edemail.getText().toString();
//           final String name = edname.getText().toString();
//           String gender = edgender.getText().toString();
//           String location = edlocation.getText().toString();
//           databaseuser.addValueEventListener(new ValueEventListener() {
//               @Override
//               public void onDataChange(@NonNull DataSnapshot snapshot) {
//                   for (DataSnapshot da: snapshot.getChildren()){
//                       if (da.child("email").getValue().equals(email)){
//                           edname.setText(da.child("name").getValue(String.class));
//                           edgender.setText(da.child("gender").getValue(String.class));
//                           edlocation.setText(da.child("location").getValue(String.class));
//                       }
//                   }
//               }
//
//               @Override
//               public void onCancelled(@NonNull DatabaseError error) {
//
//               }
//           });



//        videoView = (VideoView) mUser.findViewById(R.id.idvduser);
//       videoView.setVideoPath("https://firebasestorage.googleapis.com/v0/b/football-news-36e6b.appspot.com/o/MVC.mp4?alt=media&token=e9a418e4-653b-41a4-a08a-c7717a3c5eca");
//        videoView.start();
        return mUser;
    }
}

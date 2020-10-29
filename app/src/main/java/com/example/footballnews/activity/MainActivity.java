package com.example.footballnews.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.footballnews.R;
import com.example.footballnews.activity.main.Home;
import com.example.footballnews.activity.User.User;
import com.example.footballnews.activity.main.bxh;
import com.example.footballnews.activity.main.lich;
import com.example.footballnews.activity.main.notification;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.example.footballnews.model.BottomNavigationBehavior;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.idNavigationbottom);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationBehavior());
        bottomNavigationView.setOnNavigationItemSelectedListener(mbottomNavigationView);
        loadFragment(new Home());
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.idFramelayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mbottomNavigationView
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.idHome:
                    fragment = new Home();
                    loadFragment(fragment);
                    return true;
                case R.id.idChart:
                    fragment = new bxh();
                    loadFragment(fragment);
                    return true;
                case R.id.idDay:
                    fragment = new lich();
                    loadFragment(fragment);
                    return true;
                case R.id.idNotifi:
                    fragment = new notification()       ;
                    loadFragment(fragment);
                    return  true;
                case R.id.idUser:
                    fragment = new User();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
}
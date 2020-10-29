package com.example.footballnews.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.footballnews.DetailMatch.Chartteam;
import com.example.footballnews.DetailMatch.Infodetail;
import com.example.footballnews.DetailMatch.Lineup;
import com.example.footballnews.DetailMatch.Sumary;
import com.example.footballnews.R;
import com.example.footballnews.activity.MainActivity;
import com.example.footballnews.model.viewmatch;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class DetailMatch extends AppCompatActivity {
    private viewmatch viewmatchs;
    Button bttohome;
    TextView tvFTdm, tvStagedm, tvName1dm,tvName2dm,tvScore1dm,tvScore2dm,tvLeaguedtm, tvrounddm;
    ImageView ivTeam1dm, ivTeam2dm;
    BottomNavigationView bottomNavigationViewdtm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_match);
        Intent intentdm = getIntent();
        viewmatchs = (viewmatch) intentdm.getSerializableExtra("Match");
        tvFTdm = (TextView) findViewById(R.id.idFulltimedtm);
        tvStagedm = (TextView) findViewById(R.id.idStagedm);
        tvName1dm = (TextView) findViewById(R.id.idName1dm);
        tvName2dm = (TextView) findViewById(R.id.idName2dm);
        tvScore1dm = (TextView) findViewById(R.id.idScore1dm);
        tvScore2dm = (TextView) findViewById(R.id.idScore2dm);
        tvrounddm = (TextView) findViewById(R.id.idrounddm);
        tvLeaguedtm = (TextView) findViewById(R.id.idLeagueDetailM);
        ivTeam1dm = (ImageView) findViewById(R.id.idTeam1dm);
        ivTeam2dm = (ImageView) findViewById(R.id.idTeam2dm);
        tvFTdm.setText(viewmatchs.getFTHT());
        tvStagedm.setText(viewmatchs.getStage());
        tvName1dm.setText(viewmatchs.getName1());
        tvName2dm.setText(viewmatchs.getName2());
        tvScore1dm.setText(viewmatchs.getScore1());
        tvScore2dm.setText(viewmatchs.getScore2());
        tvLeaguedtm.setText(viewmatchs.getLeague());
        tvrounddm.setText(viewmatchs.getRound());
        Picasso.get().load(viewmatchs.getTeam1()).into(ivTeam1dm);
        Picasso.get().load(viewmatchs.getTeam2()).into(ivTeam2dm);
        bttohome = (Button) findViewById(R.id.iddtmhome);
        bttohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailMatch.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bottomNavigationViewdtm = (BottomNavigationView) findViewById(R.id.idbottomdtm);
        bottomNavigationViewdtm.setOnNavigationItemSelectedListener(mbottomNavigationViewdtm);
        loadFragmentdm(new Sumary());
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mbottomNavigationViewdtm =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmentdm;
            switch (item.getItemId()){
                case R.id.iddienbien:
                  fragmentdm = new Sumary();
                  loadFragmentdm(fragmentdm);
                  return  true;
                case  R.id.iddoihinh:
                    fragmentdm = new Lineup();
                    loadFragmentdm(fragmentdm);
                return  true;
                case R.id.idthongso :
                fragmentdm = new Infodetail();
                loadFragmentdm(fragmentdm);
                return true;
                case R.id.idbangxephang:
                    fragmentdm = new Chartteam();
                    loadFragmentdm(fragmentdm);
                return true;
            }
            return false;
        }
    };

    private void loadFragmentdm(Fragment fragmentdm) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.idFramelayoutdtm, fragmentdm);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

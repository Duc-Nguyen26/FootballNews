package com.example.footballnews.DetailMatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.footballnews.R;
import com.example.footballnews.model.viewmatch;

import java.io.Serializable;

public class Infodetail extends Fragment implements Serializable {
    private View mInfodetail;
    private viewmatch viewmatchdetail;
    ImageView ivsolieu, ivthaynguoi, ivchamdiem, ivmanofmatch;
    TextView tvsolieu, tvmanmatch;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        mInfodetail = inflater.inflate(R.layout.activity_infodetail, container, false);
        Intent intentdetail = getActivity().getIntent();
        viewmatchdetail = (viewmatch) intentdetail.getSerializableExtra("Match");
        ivsolieu = (ImageView) mInfodetail.findViewById(R.id.idimagesolieu);
        ivthaynguoi = (ImageView) mInfodetail.findViewById(R.id.idimagethaynguoi);
        ivchamdiem = (ImageView) mInfodetail.findViewById(R.id.idimagethaynguoi);
        ivmanofmatch = (ImageView) mInfodetail.findViewById(R.id.idimagemanmatch);
        tvsolieu = (TextView) mInfodetail.findViewById(R.id.idviewsolieu);
        tvmanmatch = (TextView) mInfodetail.findViewById(R.id.idviewmanofmatch);
        return mInfodetail;
    }
}

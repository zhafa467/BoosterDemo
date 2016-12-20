package com.zhafa467.boosterdemo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhafa467.boosterdemo.R;
import com.zhafa467.boosterdemo.common.InvestorTypeScheme;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan zhang on 16/12/20.
 */

public class InvestorDetailsFragment extends Fragment {
    public static final String PIC_IDS = "pic_ids";

    @BindView(R.id.ivPic1)
    ImageView picView1;
    @BindView(R.id.ivPic2)
    ImageView picView2;
    @BindView(R.id.ivPic3)
    ImageView picView3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investor_details, container, false);
        ButterKnife.bind(this, view);
        int[] ids = getArguments().getIntArray(PIC_IDS);
        if (ids != null) {
            setImageWithId(picView1, ids[0]);
            setImageWithId(picView1, ids[1]);
            setImageWithId(picView1, ids[2]);
        }
        return view;
    }

    private void setImageWithId(ImageView imageView, int id) {
        if (id != InvestorTypeScheme.NONE)
            imageView.setImageDrawable(getResources().getDrawable(id));
    }

}

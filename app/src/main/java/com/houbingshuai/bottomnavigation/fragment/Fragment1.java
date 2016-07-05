package com.houbingshuai.bottomnavigation.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.houbingshuai.bottomnavigation.Base.BaseFragment;
import com.houbingshuai.bottomnavigation.R;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Fragment1 extends BaseFragment{
    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment1_main, container, false);
    }

    @Override
    protected void findViewsById(View view) {

    }

    @Override
    protected void onClickEvent(View v) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void refreshListener() {

    }
}

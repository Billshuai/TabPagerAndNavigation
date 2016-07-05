package com.houbingshuai.bottomnavigation.Base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/4.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    public View initView(LayoutInflater inflater, ViewGroup container) {
        View pView = loadViewLayout(inflater, container);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        findViewsById(pView);
        initData();
        setFragmentLogic();
        setListener();
        return pView;
    }

    protected abstract View loadViewLayout(LayoutInflater inflater,
                                           ViewGroup container);

    protected abstract void findViewsById(View view);

    protected void initData() {
    }

    ;

    protected abstract void onClickEvent(View v);

    protected abstract void setListener();

    protected abstract void refreshListener();

    protected void setFragmentLogic() {
    }

    @Override
    public void onClick(View v) {

    }
}

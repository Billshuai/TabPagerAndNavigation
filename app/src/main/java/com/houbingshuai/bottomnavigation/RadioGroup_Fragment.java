package com.houbingshuai.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.houbingshuai.bottomnavigation.fragment.Fragment1;
import com.houbingshuai.bottomnavigation.fragment.Fragment2;
import com.houbingshuai.bottomnavigation.fragment.Fragment3;

/**
 * Created by Administrator on 2016/7/5.
 */
public class RadioGroup_Fragment extends FragmentActivity implements View.OnClickListener {
    /**
     * 切换radiobutton的id
     */
    private int tabIds[] = new int[]{
            R.id.main_rb_01,
            R.id.main_rb_02,
            R.id.main_rb_03,
    };
    private final int ONE = 0;
    private final int TEO = 1;
    private final int THIRD = 2;
    private RadioGroup radioGroup;
    private RadioButton main_rb_01;
    private RadioButton main_rb_02;
    private RadioButton main_rb_03;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiogroup_fragment);
        initView();
        initData();
    }

    public void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_home);
        main_rb_01 = (RadioButton) findViewById(R.id.main_rb_01);
        main_rb_02 = (RadioButton) findViewById(R.id.main_rb_02);
        main_rb_03 = (RadioButton) findViewById(R.id.main_rb_03);
    }

    public void initData() {
        radioGroup.setOnCheckedChangeListener(checkListener);
        switchRadioCheckState(ONE);

    }

    private RadioGroup.OnCheckedChangeListener checkListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //改变radiobutton的选中状态
            for (int i = 0; i < tabIds.length; i++) {
                if (tabIds[i] == checkedId) {
                    switchRadioCheckState(i);
                    break;
                }
            }
        }
    };

    @Override
    public void onClick(View v) {

    }

    private void switchRadioCheckState(int i) {
        hideFragments();
        switch (i) {
            case ONE:
                main_rb_01.setChecked(true);
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                    FragTools.addFragmetWithAnim(getSupportFragmentManager(),
                            fragment1, R.id.main_framelayout);
                } else {
                    FragTools.showFragment(getSupportFragmentManager(),
                            fragment1);
                }
                break;
            case TEO:
                main_rb_02.setChecked(true);
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                    FragTools.addFragmetWithAnim(getSupportFragmentManager(),
                            fragment2, R.id.main_framelayout);
                } else {
                    FragTools.showFragment(getSupportFragmentManager(),
                            fragment2);
                }
                break;
            case THIRD:
                main_rb_03.setChecked(true);
                if (fragment3 == null) {
                    fragment3 = new Fragment3();
                    FragTools.addFragmetWithAnim(getSupportFragmentManager(),
                            fragment3, R.id.main_framelayout);
                } else {
                    FragTools.showFragment(getSupportFragmentManager(),
                            fragment3);
                }
                break;
        }
    }

    /**
     * 隐藏所有的fragment
     */
    private void hideFragments() {
        if (fragment1 != null)
            FragTools.hideFragmentWithAnim(getSupportFragmentManager(),
                    fragment1);
        if (fragment2 != null)
            FragTools.hideFragmentWithAnim(getSupportFragmentManager(),
                    fragment2);
        if (fragment3 != null)
            FragTools.hideFragmentWithAnim(getSupportFragmentManager(),
                    fragment3);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment1 == null && fragment instanceof Fragment1) {
            fragment1 = (Fragment1) fragment;
        } else if (fragment2 == null && fragment instanceof Fragment2) {
            fragment2 = (Fragment2) fragment;
        } else if (fragment3 == null && fragment instanceof Fragment3) {
            fragment3 = (Fragment3) fragment;
        }
    }
}

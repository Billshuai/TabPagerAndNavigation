package com.houbingshuai.bottomnavigation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.houbingshuai.bottomnavigation.fragment.Fragment1;
import com.houbingshuai.bottomnavigation.fragment.Fragment2;
import com.houbingshuai.bottomnavigation.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Fragment_ViewPage extends FragmentActivity {
    private ViewPager viewPager_main;

    private List<Fragment> fragmentsList;

    private TextView[] arr_titles;

    private TextView[] arr_lines;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_viewpage);
        initIndicateLine();
        initTabView();
        initViewPager();
    }


    private void initTabView() {

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_main_tabtitle);
        arr_titles = new TextView[4];
        for (int i = 0; i < arr_titles.length; i++) {
            TextView textView = (TextView) layout.getChildAt(i);
            arr_titles[i] = textView;
            arr_titles[i].setEnabled(true);
            arr_titles[i].setTag(i);
            arr_titles[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    viewPager_main.setCurrentItem((Integer) v.getTag());
                }
            });
            arr_titles[0].setEnabled(false);
        }
    }


    private void initViewPager() {

        viewPager_main = (ViewPager) findViewById(R.id.viewPager_main);
        fragmentsList = new ArrayList<Fragment>();

        fragmentsList.add(new Fragment1());
        fragmentsList.add(new Fragment2());
        fragmentsList.add(new Fragment3());
        fragmentsList.add(new Fragment1());


        viewPager_main.setAdapter(new MyAdapter(getSupportFragmentManager(), fragmentsList));

        viewPager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }


            @Override

            public void onPageSelected(int position) {

                for (int i = 0; i < arr_titles.length; i++) {

                    arr_titles[i].setEnabled(true);
                    arr_lines[i].setBackgroundColor(Color.TRANSPARENT);
                }

                arr_titles[position].setEnabled(false);
                arr_lines[position].setBackgroundColor(Color.WHITE);
            }
        });
        viewPager_main.setCurrentItem(0);
    }


    private void initIndicateLine() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_indicateline);
        arr_lines = new TextView[4];
        for (int i = 0; i < arr_lines.length; i++) {
            TextView view = (TextView) layout.getChildAt(i);
            arr_lines[i] = view;
            arr_lines[i].setTag(i);
            arr_lines[i].setBackgroundColor(Color.TRANSPARENT);
        }
        arr_lines[0].setBackgroundColor(Color.WHITE);
    }


    class MyAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentsList = null;
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        public MyAdapter(FragmentManager fm, List<Fragment> fragmentsList) {
            super(fm);
            this.fragmentsList = fragmentsList;
        }


        @Override
        public Fragment getItem(int arg0) {
            return fragmentsList.get(arg0);
        }
        @Override
        public int getCount() {
            return fragmentsList.size();
        }
    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_acionbar_fragment, menu);
        return true;
    }
}

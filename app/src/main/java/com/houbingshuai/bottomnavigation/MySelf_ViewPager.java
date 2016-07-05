package com.houbingshuai.bottomnavigation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class MySelf_ViewPager extends Activity {

    private ViewPager viewPager_main;

    private List<View> list = null;

    private TextView[] arr_titles = null;
/*
* 1、特殊的布局文件；
必须有<android.support.v4.view.ViewPager>节点；
在ViewPager节点上方可自定义布局，布局内可放置TextView及ImageView等控件来自定义导航条效果。
2、初始化自定义选项卡导航条，并为选项卡设置单击监听事件OnClickListener；
3、初始化ViewPager;
创建ViewPager对象：通过findViewById()方法来实现即可；
定义ViewPager中的数据源List<View>;
自定义PagerAdapter适配器；
为ViewPager对象设置适配器；
给ViewPager设置监听器（OnPageChangeListener）。
*
* */

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.myself_viewpage);


        initTabView();

        initViewPager();

    }


    private void initTabView() {

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_main_tabtitle);

        arr_titles = new TextView[3];


        for (int i = 0; i < 3; i++) {

            TextView textView = (TextView) layout.getChildAt(i);

            arr_titles[i] = textView;

            arr_titles[i].setEnabled(true);

            arr_titles[i].setBackgroundColor(Color.GRAY);

            arr_titles[i].setTag(i);

            arr_titles[i].setOnClickListener(new View.OnClickListener() {


                @Override

                public void onClick(View v) {

// 根据当前点击的position，设置ViewPager的当前item

                    viewPager_main.setCurrentItem((Integer) v.getTag());

                }

            });

        }

        arr_titles[0].setEnabled(false);

        arr_titles[0].setBackgroundColor(Color.BLUE);

    }


    private void initViewPager() {

        viewPager_main = (ViewPager) findViewById(R.id.viewPager_main);


        list = new ArrayList<View>();

        LayoutInflater inflater = LayoutInflater.from(this);

        View view1 = inflater.inflate(R.layout.fragment1_main, null);

        View view2 = inflater.inflate(R.layout.fragment2_main, null);

        View view3 = inflater.inflate(R.layout.fragment3_main, null);

        list.add(view1);

        list.add(view2);

        list.add(view3);


        viewPager_main.setAdapter(new MyAdapter(list));


        viewPager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override

            public void onPageSelected(int position) {

// 当页面切换改变时，让所有的“点”都变成可操作。

                for (int j = 0; j < arr_titles.length; j++) {

                    arr_titles[j].setEnabled(true);

                    arr_titles[j].setBackgroundColor(Color.GRAY);

                }

// 让当前点击的“点”变成不可以操作。

                arr_titles[position].setEnabled(false);

                arr_titles[position].setBackgroundColor(Color.BLUE);

            }


            @Override

            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }


            @Override

            public void onPageScrollStateChanged(int arg0) {

            }

        });

    }


    class MyAdapter extends PagerAdapter {

        private List<View> list = null;


        public MyAdapter(List<View> list) {

            this.list = list;

        }


        @Override

        public int getCount() {

            return list.size();

        }


        @Override

        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;

        }


        @Override

        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(list.get(position));

            return list.get(position);

        }


        @Override

        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(list.get(position));

        }


    }


}

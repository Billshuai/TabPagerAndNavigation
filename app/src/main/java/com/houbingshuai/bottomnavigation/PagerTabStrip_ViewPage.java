package com.houbingshuai.bottomnavigation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 * （一）、ViewPager Tab效果说明：
 * 导航条利用<android.support.v4.view.PagerTabStrip>标签生成；
 * 导航条会随着ViewPager内容物的滑动而发生左右侧滑。
 * （二）、ViewPager 实现带滑动导航条选项卡的步骤：
 * 1、特殊的布局文件；
 * 必须有<android.support.v4.view.ViewPager>节点；
 * 在ViewPager节点中<android.support.v4.view.PagerTabStrip>子节点或者<android.support.v4.view.PagerTitleStrip>子节点，用来显示选项卡导航条。
 * 2、创建ViewPager对象：通过findViewById()方法来实现即可；
 * 3、创建PagerTabStrip对象：通过findViewById()方法来实现即可，设置PagerTabStrip；
 * 通过PagerTabStrip 对象的setTextColor()方法设置导航条文字颜色；
 * 通过PagerTabStrip 对象的setBackgroundColor ()方法设置导航条背景颜色；
 * 通过PagerTabStrip 对象的setDrawFullUnderline()方法设置导航条下方是否有完整下划线颜色；
 * 通过PagerTabStrip 对象的setTabIndicatorColor()方法设置导航条文字下方的指示颜色；
 * 通过PagerTabStrip 对象的setTextSpacing()方法设置导航条文字的间隔。
 * 4、定义ViewPager中的数据源List<View>，自定义PagerAdapter适配器；
 * 5、为ViewPager对象设置适配器。
 */
public class PagerTabStrip_ViewPage extends Activity {
    private List<View> list_views;

    private List<String> list_titles;

    private ViewPager viewPager_main;

    private PagerTabStrip pagerTabStrip_main;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.pagertabstrip_viewpage);


        viewPager_main = (ViewPager) findViewById(R.id.viewpager_main);

        pagerTabStrip_main = (PagerTabStrip) findViewById(R.id.pagerTabStrip_main);


        pagerTabStrip_main.setTextColor(Color.WHITE);

        pagerTabStrip_main.setBackgroundColor(Color.BLACK);

        pagerTabStrip_main.setDrawFullUnderline(true);

        pagerTabStrip_main.setTabIndicatorColor(Color.CYAN);

        pagerTabStrip_main.setTextSpacing(50);


        list_views = new ArrayList<View>();

        list_titles = new ArrayList<String>();

        LayoutInflater inflater = LayoutInflater.from(this);

        View view1 = inflater.inflate(R.layout.fragment1_main, null);

        View view2 = inflater.inflate(R.layout.fragment2_main, null);

        View view3 = inflater.inflate(R.layout.fragment3_main, null);

        View view4 = inflater.inflate(R.layout.fragment1_main, null);


        list_views.add(view1);

        list_views.add(view2);

        list_views.add(view3);

        list_views.add(view4);


        list_titles.add("View1");

        list_titles.add("View2");

        list_titles.add("View3");

        list_titles.add("View4");


        viewPager_main.setAdapter(new MyAdapter(list_views, list_titles));

    }


    class MyAdapter extends PagerAdapter {

        private List<View> list = null;

        private List<String> list_titles = null;


        public MyAdapter(List<View> list, List<String> list_titles) {

            this.list = list;

            this.list_titles = list_titles;

        }


        @Override

        public int getCount() {

            if (list != null) {

                return list.size();

            }

            return 0;

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


        @Override

        public CharSequence getPageTitle(int position) {

            return list_titles.get(position);

        }

    }

}

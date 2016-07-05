package com.houbingshuai.bottomnavigation;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.houbingshuai.bottomnavigation.Utils.DensityUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Toolbar
    private Toolbar toolbar;
    private TextView tv_title;


    //popupwindow

    private PopupWindow popupWindow = null;
    private LinearLayout ll_01;
    private LinearLayout ll_02;
    private LinearLayout ll_03;
    private LinearLayout ll_04;
    private LinearLayout ll_05;
    private LinearLayout ll_06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // No Titlebar

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);

        //Toolbar属性的设置
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_title = (TextView) toolbar.findViewById(R.id.tv_title);
        if (toolbar != null) {
            toolbar.setTitle("");
        }
//        toolbar.setSubtitle("作者：侯兵帅");
//        toolbar.setLogo(R.drawable.logo_red);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    //加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    // 设定菜单各按鈕的动作
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_other:
                    showPopupMenu();
                    break;
            }
            return true;
        }
    };

    private void showPopupMenu() {
        //设置contentView
        LayoutInflater li = LayoutInflater.from(this);
        View popupView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popupwindow_home, null);

        initPopupwindowView(popupView);

        // 生成一个popupwindow
        popupWindow = new PopupWindow(popupView,
                DensityUtil.dip2px(MainActivity.this, 300), ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //设置透明背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // pop.setFocusable(true);//获得焦点
        popupWindow.setOutsideTouchable(true);
        //显示PopupWindow
        //  View rootview = LayoutInflater.from(HomeActivity.this).inflate(R.layout.activity_home, null);
        //  popupWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        popupWindow.showAsDropDown(findViewById(R.id.action_other));
    }

    private void initPopupwindowView(View view) {
        ll_01 = (LinearLayout) view.findViewById(R.id.ll_01);
        ll_02 = (LinearLayout) view.findViewById(R.id.ll_02);
        ll_03 = (LinearLayout) view.findViewById(R.id.ll_03);
        ll_04 = (LinearLayout) view.findViewById(R.id.ll_04);
        ll_05 = (LinearLayout) view.findViewById(R.id.ll_05);
        ll_06 = (LinearLayout) view.findViewById(R.id.ll_06);

        ll_01.setOnClickListener(this);
        ll_02.setOnClickListener(this);
        ll_03.setOnClickListener(this);
        ll_04.setOnClickListener(this);
        ll_05.setOnClickListener(this);
        ll_06.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_01:
                startActivity(new Intent(MainActivity.this,TabActivity_TabHost.class));
                popupWindow.dismiss();
                break;
            case R.id.ll_02:
                startActivity(new Intent(MainActivity.this,TabActivity_RadioGroup.class));
                popupWindow.dismiss();
                break;
            case R.id.ll_03:
                startActivity(new Intent(MainActivity.this,PagerTabStrip_ViewPage.class));
                popupWindow.dismiss();
                break;
            case R.id.ll_04:
                startActivity(new Intent(MainActivity.this,MySelf_ViewPager.class));
                popupWindow.dismiss();
                break;
            case R.id.ll_05:
                startActivity(new Intent(MainActivity.this,Fragment_ViewPage.class));
                popupWindow.dismiss();
                break;
            case R.id.ll_06:
                startActivity(new Intent(MainActivity.this,RadioGroup_Fragment.class));
                popupWindow.dismiss();
                break;
        }
    }

    /**
     * 按两次返回键退出程序
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private long mExitTime;
}

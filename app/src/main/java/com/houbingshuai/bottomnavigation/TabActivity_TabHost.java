package com.houbingshuai.bottomnavigation;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.houbingshuai.bottomnavigation.activtity.Activtity1;
import com.houbingshuai.bottomnavigation.activtity.Activtity2;
import com.houbingshuai.bottomnavigation.activtity.Activtity3;

public class TabActivity_TabHost extends TabActivity {
    /*
    * 1、写选型卡页面特殊的布局文件：
    根节点必须是TabHost，属性android:id="@android:id/tabhost" 是固定值；
    必须有子节点TabWidget，必须有属性android:id="@android:id/tabs"；
    必须有一个FrameLayout布局节点，属性必须是android:id="@android:id/tabcontent"。
    2、继承TabActivity：（以前学习的过程中都是继承android.app.Activity类，但是这里需要继承android.app.TabActivity）
    3、创建TabHost对象：通过getTabHost()方法来实现。
    4、分别创建TabSpec对象：
    通过TabHost对象的newTabSpec()方法创建TabSpec对象；
    通过setIndicator()设置标签和图标；
    通过setContent()设置内容。
    5、TabHost对象添加TabSpec对象。通过TabHost对象的addTab()方法实现添加选项卡。

    *
    * */

    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabactivtiy_tabhost);

        tabHost = this.getTabHost();
        tabHost.addTab(tabHost.newTabSpec("Activtity1").setIndicator("Activtity1").setContent(new Intent(this, Activtity1.class)));
        tabHost.addTab(tabHost.newTabSpec("Activtity2").setIndicator("2").setContent(new Intent(this, Activtity2.class)));
        tabHost.addTab(tabHost.newTabSpec("Activtity3").setIndicator("3").setContent(new Intent(this, Activtity3.class)));
    }
}

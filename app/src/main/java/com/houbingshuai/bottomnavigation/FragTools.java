package com.houbingshuai.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.io.Serializable;


/**
 * @Des: 碎片管理类
 */
public class FragTools {

    /**
     * 不带动画的添加Fragment
     *
     * @param manager    碎片管理器
     * @param target     目标碎片
     * @param resourceId id
     * @param tag        标识
     */
    public static void addFragmet(FragmentManager manager, Fragment target,
                                  int resourceId, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(resourceId, target, tag);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 带动画的添加Fragment---FragmentManager
     *
     * @param manager
     * @param target
     * @param resourceId
     */
    public static void addFragmetWithAnim(FragmentManager manager,
                                          Fragment target, int resourceId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(resourceId, target);
        transaction.commitAllowingStateLoss();

    }

    /**
     * 带动画的添加Fragment
     *
     * @param currate
     * @param target
     * @param resourceId
     */
    public static void addFragmetWithAnim(Fragment currate, Fragment target,
                                          int resourceId) {
        FragmentTransaction transaction = currate.getFragmentManager()
                .beginTransaction();
        transaction.add(resourceId, target);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();

    }

    /**
     * 带动画的添加Fragment
     *
     * @param manager
     * @param target
     * @param resourceId
     * @param tag
     */
    public static void addFragmetWithAnim(FragmentManager manager,
                                          Fragment target, int resourceId, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(resourceId, target, tag);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 不带动画的切换Fragment
     *
     * @param currate
     * @param target
     * @param resourceId
     */
    public static void replaceFragmet(Fragment currate, Fragment target,
                                      int resourceId) {
        FragmentTransaction transaction = currate.getFragmentManager()
                .beginTransaction();
        transaction.replace(resourceId, target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 不带动画的切换Fragment
     *
     * @param activity
     * @param target
     * @param resourceId
     */
    public static void replaceFragmet(FragmentActivity activity,
                                      Fragment target, int resourceId) {
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(resourceId, target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 不带动画的切换Fragment并传值
     *
     * @param activity
     * @param target
     * @param resourceId
     * @param obj
     */
    public static void replaceFragmetForResult(FragmentActivity activity,
                                               Fragment target, int resourceId, Object obj) {
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", (Serializable) obj);
        target.setArguments(bundle);
        transaction.replace(resourceId, target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 带动画的切换Fragment
     *
     * @param activity
     * @param target
     * @param resourceId
     */
    public static void replaceFragmetWithAnim(FragmentActivity activity,
                                              Fragment target, int resourceId) {
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(resourceId, target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 带动画的切换Fragment
     *
     * @param currate
     * @param target
     * @param resourceId
     */
    public static void replaceFragmetWithAnim1(Fragment currate,
                                               Fragment target, int resourceId) {
        FragmentTransaction transaction = currate.getFragmentManager()
                .beginTransaction();
        transaction.replace(resourceId, target);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 带动画的切换Fragment并传值
     *
     * @param currate
     * @param target
     * @param resourceId
     */
    public static void replaceFragmetWithAnimForResult(Fragment currate,
                                                       Fragment target, int resourceId, Object obj) {
        FragmentTransaction transaction = currate.getFragmentManager()
                .beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", (Serializable) obj);
        target.setArguments(bundle);
        transaction.replace(resourceId, target);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 带动画的移除一个Fragment
     *
     * @param manager
     * @param target
     */
    public static void removeFragmet(FragmentManager manager, Fragment target) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(target);
        transaction.commitAllowingStateLoss();

    }

    /**
     * @param manager
     * @param target
     * @Description:带动画显示
     */
    public static void showFragment(FragmentManager manager, Fragment target) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * @param manager
     * @param target
     * @Description:带动画隐藏
     */
    public static void hideFragmentWithAnim(FragmentManager manager, Fragment target) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(target);
        transaction.commitAllowingStateLoss();
    }

    /**
     * @param manager
     * @param target
     * @Description:不带带动画隐藏
     */
    public static void hideFragment(FragmentManager manager, Fragment target) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(target);
        transaction.commitAllowingStateLoss();
    }
}

package com.mobile_core.module_main.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.mvvm.ParentViewModel;
import com.mobile_core.module_main.R;

import java.lang.reflect.Field;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

public class BottomFragmentViewModel extends ParentViewModel<BottomFragmentContract.View>
        implements BottomFragmentContract.ViewModel{
    private String mCurrentFragmentTag;
    private FragmentManager fragmentManager;

    public void setUpBottomNavigation(BottomNavigationView bottomNavigationView) {
        // 取消三个以上item的放大缩小效果
        disableShiftMode(bottomNavigationView);
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            // 5.0 以下取消涟漪效果
            bottomNavigationView.setItemBackgroundResource(0);
        }
    }

    @SuppressLint("RestrictedApi")
    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    public void onNavigationItemSelect(BottomNavigationView bottomNavigationView) {
        fragmentManager = view.getSupportActivity().getSupportFragmentManager();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            String tag;
            if(fragmentManager != null){
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment current = fragmentManager.findFragmentByTag(mCurrentFragmentTag);
                if(!TextUtils.isEmpty(mCurrentFragmentTag) && current != null){
                    transaction.hide(current);
                }
                int i = item.getItemId();
                if (i == R.id.navigation_home) {
                    tag = RouterManager.MODEL_MAIN_FRAGMENT;
                    fragment = fragmentManager.findFragmentByTag(tag);
                    if(fragment == null){
                        fragment = (Fragment) ARouter.getInstance()
                                .build(RouterManager.MODEL_MAIN_FRAGMENT).navigation();
                    }
                    switchFragment(transaction, fragment, tag);
                    return true;
                }else if(i == R.id.navigation_answer){
                    return true;
                }else if(i == R.id.navigation_pps){
                    return true;
                }else if(i == R.id.navigation_personal){
                    tag = RouterManager.MODEL_PERSONA_MINE_FRAGMENT;
                    fragment = fragmentManager.findFragmentByTag(tag);
                    if(fragment == null){
                        fragment = (Fragment) ARouter.getInstance()
                                .build(RouterManager.MODEL_PERSONA_MINE_FRAGMENT).navigation();
                    }
                    switchFragment(transaction, fragment, tag);
                    return true;
                }
            }
            return false;
        });
    }

    private void switchFragment(FragmentTransaction transaction, Fragment fragment, String tag) {
        if(fragment != null && fragment.isAdded()){
            transaction.show(fragment);
        }else{
            transaction.replace(view.getContainerView(), fragment,tag);
        }
        mCurrentFragmentTag = tag;
        transaction.commit();
    }

    public void onSideMenuItemSelect(NavigationView sideMenuView) {
        sideMenuView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance().startActivity(RouterManager.MODEL_PERSONA_LOGIN);
            }
        });

        sideMenuView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.nav_share){
                view.toast("分享！");
            }else if(id == R.id.nav_theme){
                view.toast("切换模式！");
            }else if(id  == R.id.nav_manage){
                view.toast("设置！");
            }
            return true;
        });
    }
}

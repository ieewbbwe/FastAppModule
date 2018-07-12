package com.mobile_core.module_main.main;

import android.Manifest;
import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.mobile_core.lib_comment.manager.PermissionManager;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

/**
 * Created by picher on 2018/7/5.
 * Describe：MainActivity ViewModel
 */

public class MainViewModel extends ParentViewModel<MainContract.View>
        implements MainContract.ViewModel{

    public void onClickMine(View v){
        RouterManager.getInstance().startMineActivity();
        /*RxView.clicks(v).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
        });*/
    }

    @Override
    public void onAnswerClick() {

    }

    @Override
    public void onClickMine(MainContract.View v) {

    }

    @Override
    public void onPPSClick() {

    }

    @Override
    public void onFragmnetsClick() {
        RouterManager.getInstance().startBottomFragmentActivity();

    }

    @Override
    public void onCommonUtilsClick(){

    }

    public void requestPermission() {
        PermissionManager.with((Activity) view).
                addPermission(Manifest.permission.ACCESS_FINE_LOCATION).
                addPermission(Manifest.permission.ACCESS_COARSE_LOCATION).
                addPermission(Manifest.permission.READ_EXTERNAL_STORAGE).
                addPermission(Manifest.permission.CAMERA).
                addPermission(Manifest.permission.CALL_PHONE).
                addPermission(Manifest.permission.READ_PHONE_STATE).
                initPermission();
    }

}

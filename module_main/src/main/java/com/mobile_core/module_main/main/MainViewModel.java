package com.mobile_core.module_main.main;

import android.Manifest;
import android.app.Activity;
import android.view.View;

import com.mobile_core.lib_comment.manager.PermissionManager;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;

/**
 * Created by picher on 2018/7/5.
 * Describe：MainActivity ViewModel
 */

public class MainViewModel extends ParentViewModel<MainContract.View>
        implements MainContract.ViewModel{

    @Override
    public void onMainClick() {
        RouterManager.getInstance().startActivity(RouterManager.MODEL_MAIN_BOTTOM_FRAGMENT);
    }

    @Override
    public void onAnswerClick() {
        RouterManager.getInstance().startActivity(RouterManager.MODEL_EXAM_ACTIVITY);
    }

    @Override
    public void onPPSClick() {
        RouterManager.getInstance().startActivity(RouterManager.MODEL_PPS_ACTIVITY);
    }

    @Override
    public void onMineClick(View v) {
        RouterManager.getInstance().startActivity(RouterManager.MODEL_PERSONA_MINE);
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

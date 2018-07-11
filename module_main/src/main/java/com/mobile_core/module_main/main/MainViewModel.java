package com.mobile_core.module_main.main;

import android.util.Log;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
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

    public void onClickNews(){

    }

    public void onClickFragment(){

    }

}

package com.mobile_core.lib_comment;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mobile_core.lib_comment.manager.NotificationManager;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.manager.SharedPrefManager;
import com.mobile_core.lib_comment.manager.UncaughtException;
import com.mobile_core.lib_comment.manager.image.ImageLoadFactory;

/**
 * Created by picher on 2018/7/5.
 * Describe：Base Application for some init
 */

public class BasicApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefManager.init(getApplicationContext());
        ImageLoadFactory.init(getApplicationContext());
        NotificationManager.getInstance().init(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(UncaughtException.getInstance(getApplicationContext()));
        RouterManager.init(this);

        MultiDex.install(this);
    }
}

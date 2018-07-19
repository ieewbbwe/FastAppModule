package com.mobile_core.base;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.mobile_core.base.databases.DatabasesManager;
import com.mobile_core.base.manager.NotificationManager;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.manager.SharedPrefManager;
import com.mobile_core.base.manager.UncaughtException;
import com.mobile_core.base.manager.image.ImageLoadFactory;

/**
 * Created by picher on 2018/7/5.
 * Describe：Base Application for some init
 */

public class BasicApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        LocationManager.init(getApplicationContext());
        RouterManager.init(this);
        SharedPrefManager.init(getApplicationContext());
        ImageLoadFactory.init(getApplicationContext());
        NotificationManager.getInstance().init(getApplicationContext());
        DatabasesManager.init(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(UncaughtException.getInstance(getApplicationContext()));

        MultiDex.install(this);
    }
}

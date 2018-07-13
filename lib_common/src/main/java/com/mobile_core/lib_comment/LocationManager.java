package com.mobile_core.lib_comment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;

import static com.mobile_core.lib_comment.utils.Lg.isDebug;

/**
 * Created by picher on 2018/7/12.
 * Describe：获取系统资源
 */

public class LocationManager {
    private static LocationManager mInstance;
    private Context applicationContext;
    private boolean isDebug = true;

    private LocationManager() {
    }

    private LocationManager(Context context) {
        this.applicationContext = context;
    }

    public static void init(Context context) {
        if (mInstance == null) {
            synchronized (LocationManager.class) {
                mInstance = new LocationManager(context);
            }
        }
    }

    public static LocationManager getInstance(){
        if(mInstance == null){
            throw new IllegalStateException("Must call init before use getInstance!!");
        }
        return mInstance;
    }

    public Context getApplicationContext(){
        return applicationContext;
    }

    //TODO Consider of I18N
    public String getStringByResource(@StringRes int resourceId){
        return applicationContext.getResources().getString(resourceId);
    }

    public boolean isDebug() {
        return isDebug;
    }
}

package com.mobile_core.base.manager;

/**
 * Created by picher on 2018/7/19.
 * Describe：
 */

public class SettingManager {

    private static SettingManager mInstance;
    private boolean isAutoLogin;

    private SettingManager(){}

    public static SettingManager getInstance(){
        if(mInstance == null){
            throw new IllegalStateException("SettingManager must be init before ues!!");
        }
        return mInstance;
    }

    public static void init(){
        if(mInstance == null){
            synchronized (SettingManager.class){
                mInstance = new SettingManager();
            }
        }
    }

    public boolean isAutoLogin(){
        return isAutoLogin;
    }

    public void setAutoLogin(boolean autoLogin) {
        isAutoLogin = autoLogin;
    }
}

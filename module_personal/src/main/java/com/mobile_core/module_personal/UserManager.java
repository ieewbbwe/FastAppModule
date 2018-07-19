package com.mobile_core.module_personal;

import com.mobile_core.base.bean.personal.ProfileModel;

/**
 * Created by picher on 2018/7/19.
 * Describe：用于获取用户相关数据
 */

public class UserManager {
    private static UserManager mInstance;
    private ProfileModel currentProfile;

    private UserManager(){}

    public static UserManager getInstance(){
        if(mInstance == null){
            synchronized (UserManager.class){
                if(mInstance == null){
                    mInstance = new UserManager();
                }
            }
        }
        return mInstance;
    }

    public ProfileModel getCurrentUser(){
        return currentProfile;
    }
}

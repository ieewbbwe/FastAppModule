package com.mobile_core.lib_comment.manager;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by picher on 2018/7/11.
 * Describe：路由管理类，负责路由初始化，路由选择
 */

public class RouterManager {

    /* MODEL_PERSONAL */
    public static final String MODEL_PERSONA_MINE = "/person/mine";
    /* MODEL_MAIN */
    /* MODEL_NEWS */

    private static RouterManager mInstance;

    public static RouterManager getInstance(){
        if(mInstance == null){
            synchronized (RouterManager.class){
                mInstance = new RouterManager();
            }
        }
        return mInstance;
    }

    public static void init(Application application){
        ARouter.init(application);
    }
}

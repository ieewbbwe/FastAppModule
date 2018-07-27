package com.mobile_core.base.manager.router;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mobile_core.base.LocationManager;

/**
 * Created by picher on 2018/7/11.
 * Describe：路由管理类，负责路由初始化、统一的路由选择管理
 */
public class RouterManager {

    /* MODEL_PATH */
    public static final String MODEL_MAIN_BOTTOM_FRAGMENT = "/main/bottomActivity";
    public static final String MODEL_MAIN_FRAGMENT = "/main/mainFragment";
    public static final String MODEL_MAIN_LIST_ACTIVITY = "/main/mainListActivity";

    public static final String MODEL_PERSONA_MINE = "/person/mineActivity";
    public static final String MODEL_PERSONA_LOGIN = "/person/login";
    public static final String MODEL_PERSONA_MINE_FRAGMENT = "/person/mineFragment";

    public static final String MODEL_EXAM_ACTIVITY = "/exam/examActivity";
    public static final String MODEL_EXAM_PAPER_ACTIVITY = "/exam/examPaperActivity";

    public static final String MODEL_PPS_ACTIVITY = "/pps/ppsActivity";

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
        if(LocationManager.getInstance().isDebug()){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
        getInstance();
    }

    public void startMineActivity(){
        ARouter.getInstance().build(RouterManager.MODEL_PERSONA_MINE).navigation();
    }

    public void startBottomFragmentActivity() {
        ARouter.getInstance().build(RouterManager.MODEL_MAIN_BOTTOM_FRAGMENT).navigation();
    }

    public void startActivity(String tagPath) {
        ARouter.getInstance().build(tagPath).navigation();
    }
}

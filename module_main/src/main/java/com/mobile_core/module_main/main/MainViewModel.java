package com.mobile_core.module_main.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.module_main.ParentViewModel;

/**
 * Created by picher on 2018/7/5.
 * Describe：MainActivity ViewModel
 */

public class MainViewModel extends ParentViewModel<MainContract.View>
        implements MainContract.ViewModel{

    public void onClickMine(){
        ARouter.getInstance().build(RouterManager.MODEL_PERSONA_MINE).navigation();
    }

    public void onClickNews(){

    }

    public void onClickFragment(){

    }

}

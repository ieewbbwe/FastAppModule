package com.wisesoft.module.pps;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.wisesoft.module.pps.databinding.ActivityPpsBinding;

/**
 * Created by picher on 2018/7/13.
 * Describe：
 */

@Route(path = RouterManager.MODEL_PPS_ACTIVITY)
public class PPSActivity extends MActivity<PPSViewModel, ActivityPpsBinding>
        implements PPSContract.View{

    @Override
    protected PPSViewModel onCreateViewModel() {
        return new PPSViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pps;
    }
}

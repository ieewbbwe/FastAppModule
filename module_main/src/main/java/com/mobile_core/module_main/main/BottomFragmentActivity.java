package com.mobile_core.module_main.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;
import com.mobile_core.module_main.R;
import com.mobile_core.module_main.databinding.ActivityBottomFragmentBinding;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

@Route(path = RouterManager.MODEL_MAIN_BOTTOM_FRAGMENT)
public class BottomFragmentActivity extends MActivity<BottomFragmentViewModel, ActivityBottomFragmentBinding>
        implements BottomFragmentContract.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BottomFragmentViewModel onCreateViewModel() {
        return new BottomFragmentViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_fragment;
    }
}

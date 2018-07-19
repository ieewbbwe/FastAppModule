package com.mobile_core.module_main.main.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MFragment;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;
import com.mobile_core.module_main.R;
import com.mobile_core.module_main.databinding.FragmentMainBinding;
import com.mobile_core.module_main.main.MainViewModel;

/**
 * Created by picher on 2018/7/18.
 * Describe：
 */
@Route(path = RouterManager.MODEL_MAIN_FRAGMENT)
public class MainFragment extends MFragment<MainViewModel, FragmentMainBinding>{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected MainViewModel onCreateViewModel() {
        return new MainViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}

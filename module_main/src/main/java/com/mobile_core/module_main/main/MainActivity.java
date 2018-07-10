package com.mobile_core.module_main.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.mobile_core.module_main.NActivity;
import com.mobile_core.module_main.ParentViewModel;
import com.mobile_core.module_main.R;
import com.mobile_core.module_main.ViewModel.ToolBarViewModel;
import com.mobile_core.module_main.databinding.ActivityMMainBinding;

/**
 * Created by picher on 2018/7/5.
 * Describe：MVVM
 */

public class MainActivity extends NActivity<MainViewModel, ActivityMMainBinding> implements MainContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolBarViewModel toolBarViewModel = new ToolBarViewModel("主页", false);
        toolBarViewModel.setCustomerViewId(R.layout.tool_bar_customer_layout);
        setupToolBar(toolBarViewModel);
        binding.setToolBarViewModel(toolBarViewModel);

    }

    @Override
    protected MainViewModel onCreateViewModel() {
        return new MainViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_m_main;
    }

}

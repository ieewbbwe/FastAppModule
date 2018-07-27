package com.mobile_core.module_main.main;

import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.mvvm.MActivity;
import com.mobile_core.module_main.R;
import com.mobile_core.module_main.databinding.ActivityMainListBinding;

@Route(path = RouterManager.MODEL_MAIN_LIST_ACTIVITY)
public class MainListActivity extends MActivity<MainListViewModel, ActivityMainListBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.drawerMain, binding.toolBar, R.string.open_drawer_content_desc, R.string.close_drawer_content_desc);
        drawerToggle.syncState();
        binding.drawerMain.addDrawerListener(drawerToggle);

    }

    @Override
    protected MainListViewModel onCreateViewModel() {
        return new MainListViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_list;
    }
}

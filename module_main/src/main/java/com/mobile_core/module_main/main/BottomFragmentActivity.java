package com.mobile_core.module_main.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.mobile_core.lib_comment.mvvm.ToolBarViewModel;
import com.mobile_core.module_main.R;
import com.mobile_core.module_main.databinding.ActivityBottomFragmentBinding;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

@Route(path = RouterManager.MODEL_MAIN_BOTTOM_FRAGMENT)
public class BottomFragmentActivity extends MActivity<BottomFragmentViewModel, ActivityBottomFragmentBinding>
        implements BottomFragmentContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolBarViewModel toolBarViewModel = new ToolBarViewModel.Builder().setTitle("主页").setDrawerEnable(true).build();
        setupToolBar(toolBarViewModel, findViewById(R.id.toolBarLayout));
        toolBarViewModel.onAttach(this);
        binding.setToolBarViewModel(toolBarViewModel);

        viewModel.setUpBottomNavigation(binding.bottomNavigationView);
        viewModel.onNavigationItemSelect(binding.bottomNavigationView);
        viewModel.onSideMenuItemSelect(binding.sideMenuView);
        binding.bottomNavigationView.setSelectedItemId(binding.bottomNavigationView.getMenu().getItem(0).getItemId());

        // SideMenu 是否联动
        if (toolBarViewModel.isDrawerEnable()) {
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, findViewById(R.id.toolBar),
                    R.string.open_drawer_content_desc, R.string.close_drawer_content_desc);
            drawerToggle.syncState();
            binding.drawerLayout.addDrawerListener(drawerToggle);
        }

    }

    @Override
    protected BottomFragmentViewModel onCreateViewModel() {
        return new BottomFragmentViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_fragment;
    }

    @Override
    public int getContainerView() {
        return R.id.containerFl;
    }

}

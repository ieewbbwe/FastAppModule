package com.mobile_core.lib_comment.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile_core.lib_comment.BR;
import com.mobile_core.lib_comment.BasicActivity;
import com.mobile_core.lib_comment.R;
import com.mobile_core.lib_comment.databinding.ToolBarDefaultBinding;

/**
 * Created by picher on 2018/7/11.
 * Describe：MVVM 架构 Activity 基类 需要使用MVVM架构的Model 继承该类
 */

public abstract class MActivity<VM extends ParentViewModel, B extends ViewDataBinding>
        extends BasicActivity{

    protected B binding;
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = onCreateViewModel();
        viewModel.onAttach(this);
        binding.setVariable(BR.viewModel, viewModel);
    }

    protected abstract VM onCreateViewModel();

    protected abstract int getLayoutId();

    /**
     * 设置ToolBar属性
     *
     * @param toolBarViewModel ToolBar 控制类
     */
    public void setupToolBar(ToolBarViewModel toolBarViewModel,View toolBarLayout) {
        ToolBarDefaultBinding barBinding = DataBindingUtil.findBinding(toolBarLayout);
        if (barBinding != null) {
            setSupportActionBar(barBinding.toolBar);
            if (getSupportActionBar() != null) {
                // 显示返回按钮
                getSupportActionBar().setDisplayHomeAsUpEnabled(toolBarViewModel.isBackEnable());
                // 显示返回按钮图标
                if (toolBarViewModel.getLeftIconDrawable() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setHomeAsUpIndicator(toolBarViewModel.getLeftIconDrawable());
                }
                // Menu菜单
                if (toolBarViewModel.getMenuId() != 0) {
                    getMenuInflater().inflate(toolBarViewModel.getMenuId(), barBinding.toolBar.getMenu());
                }

                // 添加自定义布局 暂时使用addView得方式加进去
                if(toolBarViewModel.getCustomerViewId() != 0){
                    View customerView;
                    ViewDataBinding bind = DataBindingUtil.inflate(LayoutInflater.from(this),toolBarViewModel.getCustomerViewId(),null,false);
                    if(bind != null){
                        bind.setVariable(BR.viewModel, toolBarViewModel);
                        customerView = bind.getRoot();
                    }else{
                        customerView = LayoutInflater.from(this).inflate(toolBarViewModel.getCustomerViewId(), null);
                    }

                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    barBinding.toolBar.addView(customerView, layoutParams);
                    //getSupportActionBar().setCustomView(toolBarViewModel.getCustomerViewId());
                }
            }
        }
    }
}

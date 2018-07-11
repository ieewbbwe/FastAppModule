package com.mobile_core.module_main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile_core.lib_comment.BasicActivity;
import com.mobile_core.module_main.ViewModel.ToolBarViewModel;
import com.mobile_core.module_main.databinding.ToolBarDefaultBinding;

/**
 * Created by picher on 2018/7/5.
 * Describe：MVVM 架构的Activity 基类
 */

public abstract class NActivity<VM extends ParentViewModel, B extends ViewDataBinding>
        extends BasicActivity implements NView {

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
    public void setupToolBar(ToolBarViewModel toolBarViewModel) {
        ToolBarDefaultBinding barBinding = DataBindingUtil.findBinding(findViewById(R.id.toolBarLayout));
        if (barBinding != null) {
            setSupportActionBar(barBinding.toolBar);
            if (getSupportActionBar() != null) {
                // 显示返回按钮
                getSupportActionBar().setDisplayHomeAsUpEnabled(toolBarViewModel.isBackEnable());
                // 显示返回按钮图标
                if (toolBarViewModel.getLeftIconDrawble() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setHomeAsUpIndicator(toolBarViewModel.getLeftIconDrawble());
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

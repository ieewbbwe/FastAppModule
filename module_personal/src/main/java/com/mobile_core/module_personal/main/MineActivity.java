package com.mobile_core.module_personal.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;
import com.mobile_core.lib_comment.mvvm.ToolBarViewModel;
import com.mobile_core.module_personal.R;
import com.mobile_core.module_personal.databinding.ActivityMMineBinding;

@Route(path = RouterManager.MODEL_PERSONA_MINE)
public class MineActivity extends MActivity<MineViewModel,ActivityMMineBinding> implements
        MineContract.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolBarViewModel toolBarViewModel = new ToolBarViewModel("个人", false);
        setupToolBar(toolBarViewModel, findViewById(R.id.toolBarLayout));
        binding.setToolBarViewModel(toolBarViewModel);
    }

    @Override
    protected MineViewModel onCreateViewModel() {
        return new MineViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_m_mine;
    }
}

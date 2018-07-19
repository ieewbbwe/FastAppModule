package com.mobile_core.module_personal.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.mvvm.MActivity;
import com.mobile_core.base.mvvm.ToolBarViewModel;
import com.mobile_core.module_personal.R;
import com.mobile_core.module_personal.databinding.ActivityMMineBinding;

@Route(path = RouterManager.MODEL_PERSONA_MINE)
public class MineActivity extends MActivity<MineViewModel,ActivityMMineBinding>
        implements MineContract.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolBarViewModel toolBarViewModel = new ToolBarViewModel("个人", true);
        setupToolBar(toolBarViewModel, findViewById(R.id.toolBarLayout));
        toolBarViewModel.onAttach(this);
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

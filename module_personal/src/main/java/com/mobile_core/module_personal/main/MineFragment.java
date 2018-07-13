package com.mobile_core.module_personal.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MFragment;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;
import com.mobile_core.module_personal.R;
import com.mobile_core.module_personal.databinding.FragmentMineBinding;

/**
 * Created by picher on 2018/7/13.
 * Describe：
 */

@Route(path = RouterManager.MODEL_PERSONA_MINE_FRAGMENT)
public class MineFragment extends MFragment<MineViewModel, FragmentMineBinding>
        implements MineContract.View{

    @Override
    protected MineViewModel onCreateViewModel() {
        return new MineViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}

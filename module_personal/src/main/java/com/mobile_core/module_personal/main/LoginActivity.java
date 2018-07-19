package com.mobile_core.module_personal.main;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.mobile_core.lib_comment.mvvm.ParentViewModel;
import com.mobile_core.module_personal.R;
import com.mobile_core.module_personal.databinding.ActivityLoginBinding;

@Route(path = RouterManager.MODEL_PERSONA_LOGIN)
public class LoginActivity extends MActivity<LoginViewModel, ActivityLoginBinding>
        implements LoginContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected LoginViewModel onCreateViewModel() {
        return new LoginViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}

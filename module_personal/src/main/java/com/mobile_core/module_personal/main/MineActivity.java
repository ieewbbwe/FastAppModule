package com.mobile_core.module_personal.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.module_personal.R;

@Route(path = RouterManager.MODEL_PERSONA_MINE)
public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_mine);
    }
}

package com.mobile_core.base.mvvm;

import android.view.View;

import com.mobile_core.base.BasicViewModel;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

public interface ToolBarContract {
    public interface ViewModel extends BasicViewModel{
        void onLeftBackClick(View v);
    }
}

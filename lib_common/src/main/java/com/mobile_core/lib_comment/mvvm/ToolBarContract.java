package com.mobile_core.lib_comment.mvvm;

import android.view.View;

import com.mobile_core.lib_comment.BasicViewModel;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

public interface ToolBarContract {
    public interface ViewModel extends BasicViewModel{
        void onLeftBackClick(View v);
    }
}

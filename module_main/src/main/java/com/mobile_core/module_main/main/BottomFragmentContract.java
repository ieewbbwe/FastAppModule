package com.mobile_core.module_main.main;

import com.mobile_core.lib_comment.BasicView;
import com.mobile_core.lib_comment.BasicViewModel;

/**
 * Created by picher on 2018/7/12.
 * Describe：
 */

public interface BottomFragmentContract {

    public interface View extends BasicView {

        int getContainerView();
    }

    public interface ViewModel extends BasicViewModel {

    }
}

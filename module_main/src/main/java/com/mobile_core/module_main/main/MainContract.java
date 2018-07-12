package com.mobile_core.module_main.main;

import com.mobile_core.lib_comment.BasicView;
import com.mobile_core.lib_comment.BasicViewModel;

/**
 * Created by picher on 2018/7/5.
 * Describe：
 */

public class MainContract {

    public interface View extends BasicView {

    }

    public interface ViewModel extends BasicViewModel{
        void onAnswerClick();
        void onClickMine(View v);
        void onPPSClick();
        void onFragmnetsClick();
        void onCommonUtilsClick();

    }
}

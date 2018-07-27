package com.mobile_core.module_main.main;

import com.mobile_core.base.BasicView;
import com.mobile_core.base.BasicViewModel;

/**
 * Created by picher on 2018/7/5.
 * Describe：
 */

public class MainContract {

    public interface View extends BasicView {

    }

    public interface ViewModel extends BasicViewModel{
        void onMainClick();
        void onAnswerClick();
        void onPPSClick();
        void onMineClick(android.view.View v);
        void onCommonUtilsClick();
        void onMainListClick();
    }
}

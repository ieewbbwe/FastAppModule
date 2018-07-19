package com.wisesoft.module.exam.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.lib_comment.manager.RouterManager;
import com.mobile_core.lib_comment.mvvm.MActivity;
import com.wisesoft.module.exam.R;
import com.wisesoft.module.exam.databinding.ActivityExamBinding;

/**
 * Created by picher on 2018/7/13.
 * Describe：
 */

@Route(path = RouterManager.MODEL_EXAM_ACTIVITY)
public class ExamActivity extends MActivity<ExamViewModel, ActivityExamBinding>
        implements ExamContract.View{

    @Override
    protected ExamViewModel onCreateViewModel() {
        return new ExamViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exam;
    }
}

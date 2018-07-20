package com.wisesoft.module.exam.main;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.mvvm.MActivity;
import com.wisesoft.module.exam.R;
import com.wisesoft.module.exam.databinding.ActivityExamPaperBinding;

@Route(path = RouterManager.MODEL_EXAM_PAPER_ACTIVITY)
public class ExamPaperActivity extends MActivity<ExamPaperViewModel, ActivityExamPaperBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ExamPaperViewModel onCreateViewModel() {
        return new ExamPaperViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exam_paper;
    }
}

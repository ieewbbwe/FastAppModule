package com.mobile_core.base.fragment;

import com.mobile_core.base.BasicDialog;
import com.mobile_core.base.R;

/**
 * Created by picher on 2018/7/6.
 * Describe：加载进度Dialog
 */

public class LoadingDialogFragment extends BasicDialog {

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading_layout;
    }
}

package com.mobile_core.lib_comment.fragment;

import com.mobile_core.lib_comment.BasicDialog;
import com.mobile_core.lib_comment.R;

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

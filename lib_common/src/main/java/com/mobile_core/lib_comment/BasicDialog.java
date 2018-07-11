package com.mobile_core.lib_comment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by picher on 2018/7/6.
 * Describe：Dialog 基类，继承字DialogFragment
 */

public abstract class BasicDialog extends DialogFragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(getLayoutId(),null,false);
    }

    protected abstract int getLayoutId();
}

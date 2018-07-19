package com.mobile_core.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by picher on 2018/7/5.
 * Describe：MVVM View
 */

public interface BasicView {
    void showLoading(boolean show);

    void showError(String error);

    boolean isCanShowDialog();

    AppCompatActivity getSupportActivity();

    void toast(String str);
}

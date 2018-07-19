package com.mobile_core.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mobile_core.base.fragment.LoadingDialogFragment;

/**
 * Created by picher on 2018/7/5.
 * Describe：
 */

public class BasicActivity extends AppCompatActivity
        implements BasicView{

    private static final String LOADING_DIALOG_TAG = "loading_dialog_tag";
    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ShowToast")
    public void toast(int resId) {
        if (toast == null) {
            toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT);
        } else {
            toast.setText(resId);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @SuppressLint("ShowToast")
    public void toast(String str) {
        if (toast == null) {
            toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @Override
    public void showLoading(boolean show) {
        Fragment loadingDialog = getSupportFragmentManager().findFragmentByTag(LOADING_DIALOG_TAG);
        if(show){
            if(loadingDialog == null){
                new LoadingDialogFragment().show(getSupportFragmentManager(),LOADING_DIALOG_TAG);
            }
        }else{
            if(loadingDialog != null && loadingDialog instanceof DialogFragment) {
                ((DialogFragment) loadingDialog).dismiss();
            }
        }
    }

    @Override
    public void showError(String error) {
        // 暂时使用toast 需要得话 做成Dialog
        toast(error);
    }

    @Override
    public boolean isCanShowDialog() {
        return false;
    }

    @Override
    public AppCompatActivity getSupportActivity() {
        return this;
    }
}

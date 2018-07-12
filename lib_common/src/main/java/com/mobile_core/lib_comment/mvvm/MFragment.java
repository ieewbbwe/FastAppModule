package com.mobile_core.lib_comment.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile_core.lib_comment.BR;
import com.mobile_core.lib_comment.BasicFragment;
import com.mobile_core.lib_comment.BasicView;

/**
 * Created by picher on 2018/7/12.
 * Describe：MVVM Fragment 基类
 */

public abstract class MFragment<VM extends ParentViewModel,B extends ViewDataBinding>
        extends BasicFragment implements BasicView{
    protected VM viewModel;
    protected B binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),null,false);
        binding.setVariable(BR.viewModel, viewModel);
        viewModel.onAttach(this);
        return binding.getRoot();
    }

    protected abstract VM onCreateViewModel();

    protected abstract int getLayoutId();

}

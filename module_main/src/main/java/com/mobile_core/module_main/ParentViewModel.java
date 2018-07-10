package com.mobile_core.module_main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mobile_core.lib_comment.manager.AppStyleManager;

/**
 * Created by picher on 2018/1/11.
 * Describe：
 */

public abstract class ParentViewModel<V extends NView> extends BaseObservable{

    @Bindable
    public AppStyleManager style;

    public ParentViewModel(){
        this.style = AppStyleManager.getInstance();
    }

    public AppStyleManager getStyle() {
        return style;
    }

    public void setStyle(AppStyleManager style) {
        this.style = style;
    }

    protected NView view;

    public void onAttach(NView view){
        this.view = view;
    }

    public void onDetach(){
        this.view = null;
    }
}

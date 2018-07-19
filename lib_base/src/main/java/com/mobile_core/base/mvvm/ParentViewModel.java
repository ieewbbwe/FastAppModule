package com.mobile_core.base.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mobile_core.base.BasicView;
import com.mobile_core.base.BasicViewModel;
import com.mobile_core.base.LocationManager;
import com.mobile_core.base.manager.AppStyleManager;

/**
 * Created by picher on 2018/1/11.
 * Describe：
 */

public abstract class ParentViewModel<V extends BasicView> extends BaseObservable
        implements BasicViewModel{

    @Bindable
    protected AppStyleManager style;
    protected LocationManager locationManager;

    public ParentViewModel(){
        this.style = AppStyleManager.getInstance();
        this.locationManager = LocationManager.getInstance();
    }

    public AppStyleManager getStyle() {
        return style;
    }

    public void setStyle(AppStyleManager style) {
        this.style = style;
    }

    protected V view;

    public void onAttach(V view){
        this.view = view;
    }

    public void onDetach(){
        this.view = null;
    }
}

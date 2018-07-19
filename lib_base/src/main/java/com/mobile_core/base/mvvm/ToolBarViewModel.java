package com.mobile_core.base.mvvm;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by picher on 2018/7/6.
 * Describe：
 */

public class ToolBarViewModel extends ParentViewModel
        implements ToolBarContract.ViewModel {

    /*标题*/
    private String title;
    /*标题居中*/
    private boolean isTitleCenter;
    /*是否显示返回按键*/
    private boolean isBackEnable;
    /*返回键图标*/
    private Drawable leftIconDrawble;
    /*右边的标题菜单*/
    private int menuId;
    /*SideMenu 联动设置*/
    private boolean isDrawerEnable;

    /*自定义布局*/
    private int customerViewId;

    public ToolBarViewModel() {
    }

    public ToolBarViewModel(String title) {
        this.title = title;
    }

    public ToolBarViewModel(String title, boolean isBackEnable) {
        this.title = title;
        this.isBackEnable = isBackEnable;
    }

    public int getCustomerViewId() {
        return customerViewId;
    }

    public void setCustomerViewId(int customerViewId) {
        this.customerViewId = customerViewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBackEnable() {
        return isBackEnable;
    }

    public void setBackEnable(boolean backEnable) {
        isBackEnable = backEnable;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public boolean isTitleCenter() {
        return isTitleCenter;
    }

    public void setTitleCenter(boolean titleCenter) {
        isTitleCenter = titleCenter;
    }

    public Drawable getLeftIconDrawable() {
        return leftIconDrawble;
    }

    public void setLeftIconDrawble(Drawable leftIconDrawble) {
        this.leftIconDrawble = leftIconDrawble;
    }

    public boolean isDrawerEnable() {
        return isDrawerEnable;
    }

    public void setDrawerEnable(boolean drawerEnable) {
        isDrawerEnable = drawerEnable;
    }

    public ToolBarViewModel(String title, boolean isTitleCenter, boolean isBackEnable, Drawable leftIconDrawble, int menuId, boolean isDrawerEnable, int customerViewId) {
        this.title = title;
        this.isTitleCenter = isTitleCenter;
        this.isBackEnable = isBackEnable;
        this.leftIconDrawble = leftIconDrawble;
        this.menuId = menuId;
        this.isDrawerEnable = isDrawerEnable;
        this.customerViewId = customerViewId;
    }

    public static class Builder {
        private String title;
        private boolean isTitleCenter;
        private boolean isBackEnable;
        private Drawable leftIconDrawble;
        private int menuId;
        private boolean isDrawerEnable;
        private int customerViewId;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitleCenter(boolean titleCenter) {
            isTitleCenter = titleCenter;
            return this;
        }

        public Builder setBackEnable(boolean backEnable) {
            isBackEnable = backEnable;
            return this;
        }

        public Builder setLeftIconDrawble(Drawable leftIconDrawble) {
            this.leftIconDrawble = leftIconDrawble;
            return this;
        }

        public Builder setMenuId(int menuId) {
            this.menuId = menuId;
            return this;
        }

        public Builder setDrawerEnable(boolean drawerEnable) {
            isDrawerEnable = drawerEnable;
            return this;
        }

        public Builder setCustomerViewId(int customerViewId) {
            this.customerViewId = customerViewId;
            return this;
        }

        public ToolBarViewModel build() {
            return new ToolBarViewModel(title, isTitleCenter, isBackEnable, leftIconDrawble, menuId, isDrawerEnable, customerViewId);
        }
    }

    @Override
    public void onLeftBackClick(View v) {
        if (view != null && view instanceof Activity) {
            ((Activity) view).onBackPressed();
        }
    }
}

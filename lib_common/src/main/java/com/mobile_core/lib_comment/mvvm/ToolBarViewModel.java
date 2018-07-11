package com.mobile_core.lib_comment.mvvm;


import android.graphics.drawable.Drawable;

/**
 * Created by picher on 2018/7/6.
 * Describe：
 */

public class ToolBarViewModel extends ParentViewModel {

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

    public Drawable getLeftIconDrawble() {
        return leftIconDrawble;
    }

    public void setLeftIconDrawble(Drawable leftIconDrawble) {
        this.leftIconDrawble = leftIconDrawble;
    }
}

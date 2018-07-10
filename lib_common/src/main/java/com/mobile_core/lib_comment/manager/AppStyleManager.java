package com.mobile_core.lib_comment.manager;


import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;

import com.mobile_core.lib_comment.R;

/**
 * Created by picher on 2018/7/6.
 * Describe：应用主题管理类
 */
public class AppStyleManager {

    private static AppStyleManager instance;

    @ColorInt
    private int screenTintColor;
    @ColorInt
    private int screenBackgroundColor;
    @ColorInt
    private int borderLineColor;
    @ColorInt
    private int titleTextColor;
    @ColorInt
    private int textColor;
    @ColorInt
    private int buttonTextColor;
    @ColorInt
    private int alertTintColor;
    @ColorInt
    private int alertTitleTextColor;
    @ColorInt
    private int alertTextColor;
    @ColorInt
    private int placeHolderTextColor;

    protected static synchronized void init(StyleBuilderImpl motherlodeStyleBuilder) {
        if (motherlodeStyleBuilder != null) {
            instance = motherlodeStyleBuilder.build();
        } else
            throw new IllegalArgumentException("Motherlode style builder cannot be null.");
    }

    public static synchronized AppStyleManager getInstance() {
        return instance;
    }

    private AppStyleManager(int screenTintColor, int screenBackgroundColor, int borderLineColor, int titleTextColor,
                            int textColor, int buttonTextColor, int alertTintColor, int alertTitleTextColor, int
                                        alertTextColor, int placeHolderTextColor) {
        this.placeHolderTextColor = placeHolderTextColor;
        this.screenTintColor = screenTintColor;
        this.screenBackgroundColor = screenBackgroundColor;
        this.borderLineColor = borderLineColor;
        this.titleTextColor = titleTextColor;
        this.textColor = textColor;
        this.buttonTextColor = buttonTextColor;
        this.alertTintColor = alertTintColor;
        this.alertTitleTextColor = alertTitleTextColor;
        this.alertTextColor = alertTextColor;
    }

    public int getPlaceHolderTextColor() {
        return placeHolderTextColor;
    }

    public int getScreenTintColor() {
        return screenTintColor;
    }

    public int getScreenBackgroundColor() {
        return screenBackgroundColor;
    }

    public int getBorderLineColor() {
        return borderLineColor;
    }

    public int getTitleTextColor() {
        return titleTextColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getButtonTextColor() {
        return buttonTextColor;
    }

    public int getAlertTintColor() {
        return alertTintColor;
    }

    public int getAlertTitleTextColor() {
        return alertTitleTextColor;
    }

    public int getAlertTextColor() {
        return alertTextColor;
    }

    protected static class StyleBuilderImpl {

        private int screenTintColor;
        private int screenBackgroundColor;
        private int borderLineColor;
        private int titleTextColor;
        private int textColor;
        private int buttonTextColor;
        private int alertTintColor;
        private int alertTitleTextColor;
        private int alertTextColor;
        private int placeHolderTextColor;

        public StyleBuilderImpl(Context context) {
            if (context != null) {
                this.setScreenTintColor(ContextCompat.getColor(context, R.color.screenTintColor));
                this.setScreenBackgroundColor(ContextCompat.getColor(context, R.color.screenBackgroundColor));
                this.setBorderLineColor(ContextCompat.getColor(context, R.color.borderLineColor));
                this.setTitleTextColor(ContextCompat.getColor(context, R.color.titleTextColor));
                this.setTextColor(ContextCompat.getColor(context, R.color.textColor));
                this.setButtonTextColor(ContextCompat.getColor(context, R.color.buttonTextColor));
                this.setAlertTintColor(ContextCompat.getColor(context, R.color.alertTintColor));
                this.setAlertTitleTextColor(ContextCompat.getColor(context, R.color.alertTitleTextColor));
                this.setAlertTextColor(ContextCompat.getColor(context, R.color.alertTextColor));
                this.setPlaceHolderTextColor(ContextCompat.getColor(context, R.color.placeholderTextColor));
            } else
                throw new IllegalArgumentException("Context cannot be null.");
        }

        public StyleBuilderImpl setPlaceHolderTextColor(@ColorInt int placeHolderTextColor) {
            this.placeHolderTextColor = placeHolderTextColor;
            return this;
        }

        public StyleBuilderImpl setScreenTintColor(@ColorInt int screenTintColor) {
            this.screenTintColor = screenTintColor;
            return this;
        }

        public StyleBuilderImpl setScreenBackgroundColor(@ColorInt int screenBackgroundColor) {
            this.screenBackgroundColor = screenBackgroundColor;
            return this;
        }

        public StyleBuilderImpl setBorderLineColor(@ColorInt int borderLineColor) {
            this.borderLineColor = borderLineColor;
            return this;
        }

        public StyleBuilderImpl setTitleTextColor(@ColorInt int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public StyleBuilderImpl setTextColor(@ColorInt int textColor) {
            this.textColor = textColor;
            return this;
        }

        public StyleBuilderImpl setButtonTextColor(@ColorInt int buttonTextColor) {
            this.buttonTextColor = buttonTextColor;
            return this;
        }

        public StyleBuilderImpl setAlertTintColor(@ColorInt int alertTintColor) {
            this.alertTintColor = alertTintColor;
            return this;
        }

        public StyleBuilderImpl setAlertTitleTextColor(@ColorInt int alertTitleTextColor) {
            this.alertTitleTextColor = alertTitleTextColor;
            return this;
        }

        public StyleBuilderImpl setAlertTextColor(@ColorInt int alertTextColor) {
            this.alertTextColor = alertTextColor;
            return this;
        }

        public AppStyleManager build() {
            return new AppStyleManager(screenTintColor, screenBackgroundColor, borderLineColor, titleTextColor,
                    textColor, buttonTextColor, alertTintColor, alertTitleTextColor, alertTextColor,
                    placeHolderTextColor);
        }
    }
}

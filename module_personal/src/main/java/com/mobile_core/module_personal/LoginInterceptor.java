package com.mobile_core.module_personal;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.mobile_core.base.manager.router.RouterManager;
import com.mobile_core.base.utils.Lg;

/**
 * Created by picher on 2018/7/19.
 * Describe：登陆验证拦截器
 */

@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {

    private static final java.lang.String TAG = "LoginInterceptor";
    private String[] loginNeedPage = {RouterManager.MODEL_EXAM_PAPER_ACTIVITY};

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        if (isNeedLogin(path)) {
            if (UserManager.getInstance().getCurrentUser() != null) {
                callback.onContinue(postcard);
            } else {
                Lg.d(TAG, "拦截并跳转到登陆：" + path);
                callback.onInterrupt(null);
                RouterManager.getInstance().startActivity(RouterManager.MODEL_PERSONA_LOGIN);
            }
        } else {
            callback.onContinue(postcard);
        }
    }

    private boolean isNeedLogin(String path) {
        for (String str : loginNeedPage) {
            if (str.equals(path)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void init(Context context) {
        Lg.d(TAG, "登陆拦截器，初始化！");
    }
}

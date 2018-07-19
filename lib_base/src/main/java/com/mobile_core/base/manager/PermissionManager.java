package com.mobile_core.base.manager;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by picher on 2018/7/12.
 * Describe：权限管理类
 */

public class PermissionManager {

    private static final PermissionManager PERMISSION_CHECKER = new PermissionManager();

    public static PermissionManager.Builder with(Activity activity) {
        return new Builder(activity);
    }

    public static class Builder {

        private Activity mActivity;
        private List<String> permissionList;

        public Builder(@NonNull Activity activity) {
            mActivity = activity;
            permissionList = new ArrayList<>();
        }

        /**
         * Determine whether <em>you</em> have been granted a particular permission.
         *
         * @param permission The name of the permission being checked.
         * @return {@link PackageManager#PERMISSION_GRANTED} if you have the
         * permission, or {@link PackageManager#PERMISSION_DENIED} if not.
         * @see PackageManager#checkPermission(String, String)
         */
        public Builder addPermission(@NonNull String permission) {
            if (!permissionList.contains(permission)) {
                permissionList.add(permission);
            }
            return this;
        }

        public List<String> initPermission() {
            List<String> list = new ArrayList<>();
            for (String permission : permissionList) {
                if (ActivityCompat.checkSelfPermission(mActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                    list.add(permission);
                }
            }
            if (list.size() > 0) {
                ActivityCompat.requestPermissions(mActivity, list.toArray(new String[list.size()]), 1);
            }
            return list;
        }

    }

    public static boolean hasPermission(Context context, String... permission) {
        return PERMISSION_CHECKER.hasPermission(context, Arrays.asList(permission));
    }

    private boolean hasPermission(Context context, List<String> permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true;

        AppOpsManager opsManager = null;
        for (String permission : permissions) {
            int result = context.checkPermission(permission, android.os.Process.myPid(), android.os.Process.myUid());
            if (result == PackageManager.PERMISSION_DENIED) {
                return false;
            }

            String op = AppOpsManager.permissionToOp(permission);
            if (TextUtils.isEmpty(op)) {
                continue;
            }

            if (opsManager == null)
                opsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            if (opsManager != null) {
                result = opsManager.checkOpNoThrow(op, android.os.Process.myUid(), context.getPackageName());
                if (result != AppOpsManager.MODE_ALLOWED) {
                    return false;
                }
            }
        }
        return true;
    }

}

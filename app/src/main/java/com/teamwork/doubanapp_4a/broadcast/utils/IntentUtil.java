package com.teamwork.doubanapp_4a.broadcast.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.teamwork.doubanapp_4a.bmm.view.WebviewActivity;


/**
 * Intent工具类
 */

public class IntentUtil {

    /**
     * 进行页面跳转
     *
     * @param cls
     */
    public static void showIntent(Activity context, Class<?> cls, String[] keys, String[] values) {
        Intent intent = new Intent(context, cls);
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                if (!TextUtils.isEmpty(keys[i]) && !TextUtils.isEmpty(values[i])) {
                    intent.putExtra(keys[i], values[i]);
                }
            }
        }
        context.startActivity(intent);
    }

    public static void showIntent(Activity context, Class<?> clzz) {
        showIntent(context, clzz, null, null);
    }

    public static void showWebViewIntent(Activity context, String url) {

        showIntent(context, WebviewActivity.class, new String[]{"url"}, new String[]{url});
    }


}

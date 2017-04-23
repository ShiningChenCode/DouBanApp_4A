package com.teamwork.doubanapp_4a.bmm.utils;

import android.content.Context;

/**
 * Created by admin on 2017/4/23.
 */

public class DensityUtil {
    public static int dp2px(Context context, int dp) {
        return (int) (context.getResources().getDisplayMetrics().density * dp + 0.5);
    }
}

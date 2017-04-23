package com.teamwork.doubanapp_4a.home.util;

import android.content.Context;

/**
 * Created by XiaGF on 2017/4/23.
 */

public class Util {

    /**
     * 根据手机分辨率从dp的单位转化成px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, int dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
}

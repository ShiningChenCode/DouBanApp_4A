package com.teamwork.doubanapp_4a.group.view.util;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/5/8.
 */

public class GsonUtil {
	public static <T> T getClass(String info ,Class<T> cla){
		T t = new Gson().fromJson(info,cla)	;
		return t;
	}
}

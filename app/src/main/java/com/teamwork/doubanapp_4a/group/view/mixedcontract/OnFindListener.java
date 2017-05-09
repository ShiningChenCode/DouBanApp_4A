package com.teamwork.doubanapp_4a.group.view.mixedcontract;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 * 数据处理完后通过接口回调把数据传给view层
 */

public interface OnFindListener<T> {
	void findSucess(List<T> data );
	void findFailed();
}

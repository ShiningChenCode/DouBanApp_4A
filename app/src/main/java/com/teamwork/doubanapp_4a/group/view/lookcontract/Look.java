package com.teamwork.doubanapp_4a.group.view.lookcontract;

import android.util.Log;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.group.view.groupdata.MorelData;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.OnFindListener;
import com.teamwork.doubanapp_4a.group.view.util.GsonUtil;
import com.teamwork.doubanapp_4a.group.view.util.HttpUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/8.
 */

public class Look implements LookContract.ILookModel {
	String TAG = "HHH";
	@Override
	public void findLook(String url, final OnFindListener onFindListener) {
		HttpUtil.sendOkHttpRequest(url, new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				onFindListener.findFailed();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String info = response.body().string();
				MorelData morelData = GsonUtil.getClass(info, MorelData.class);
				List<MorelData.RecGroupsBean> rec_groups = morelData.getRec_groups();
				Log.i(TAG, "onResponse: " + new Gson().toJson(rec_groups));
				onFindListener.findSucess(rec_groups);
			}
		});
	}
}

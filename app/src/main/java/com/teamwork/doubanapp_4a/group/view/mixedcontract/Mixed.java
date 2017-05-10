package com.teamwork.doubanapp_4a.group.view.mixedcontract;

import com.teamwork.doubanapp_4a.group.view.groupdata.SiftData;
import com.teamwork.doubanapp_4a.group.view.util.GsonUtil;
import com.teamwork.doubanapp_4a.group.view.util.HttpUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/7.
 */

public class Mixed implements MixedContract.IFindMoreListener {


	@Override
	public void findMixedGroup(String url, final OnFindListener onFindListener) {
		HttpUtil.sendOkHttpRequest(url, new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				onFindListener.findFailed();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String info = response.body().string();
				SiftData siftData = GsonUtil.getClass(info, SiftData.class);
				List<SiftData.MixedRecGroupsBean> mixed_rec_groups = siftData
						.getMixed_rec_groups();
				onFindListener.findSucess(mixed_rec_groups);
			}
		});
	}
}

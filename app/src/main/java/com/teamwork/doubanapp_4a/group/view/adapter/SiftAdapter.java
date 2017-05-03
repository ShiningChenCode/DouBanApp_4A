package com.teamwork.doubanapp_4a.group.view.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.groupdata.SiftData;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class SiftAdapter extends CommonAdapter<SiftData> {
	private List<SiftData> mDatas;
	private Context mContext;
	String TAG = "hhh";

	public SiftAdapter(List<SiftData> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
		this.mContext = mContext;
	}

	@Override
	public int getLayoutId(int viewType) {
		return R.layout.fragment_group_sift_item;
	}

	@Override
	public void convert(CommonViewHolder holder, int position) {
		SiftData siftData = mDatas.get(position);
		ImageView contentImg = (ImageView) holder.getView(R.id.contentImg);
		contentImg.setBackgroundResource(siftData.getImgId());
	}

	@Override
	public int getItemCount() {
		Log.i(TAG, "getItemCount: " + mDatas.size());
		return mDatas.size();
	}
}

package com.teamwork.doubanapp_4a.group.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.groupdata.SiftData;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class SiftAdapter extends CommonAdapter<SiftData.MixedRecGroupsBean> {

private List<SiftData.MixedRecGroupsBean> mDatas;
	private Context mContext;
	String TAG = "hhh";
	private ItemClickListener mItemClickListener;

	public void setItemClickListener(ItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}

	public SiftAdapter(List<SiftData.MixedRecGroupsBean> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
		this.mContext = mContext;
	}

	@Override
	public int getLayoutId(int viewType) {
		return R.layout.fragment_group_sift_item;
	}

	@Override
	public void convert(CommonViewHolder holder, final int position) {
		SiftData.MixedRecGroupsBean mixedRecGroupsBean = mDatas.get(position);
		ImageView contentImg = (ImageView) holder.getView(R.id.contentImg);
		Glide.with(mContext).load(mixedRecGroupsBean.getImage()).into(contentImg);
		contentImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mItemClickListener!=null){
					mItemClickListener.onItemClickListener(v,position);
				}
			}
		});

	}

	@Override
	public int getItemCount() {
		Log.i(TAG, "getItemCount: " + mDatas.size());
		return mDatas.size();
	}
}

package com.teamwork.doubanapp_4a.group.view.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;

import java.util.List;


/**
 * Created by Administrator on 2017/1/31.
 */

public abstract class CommonAdapter<Object> extends RecyclerView.Adapter<CommonViewHolder> {

	private List<Object> mDatas;
	private Context mContext;

	public CommonAdapter(List<Object> mDatas,Context mContext){
		this.mDatas = mDatas;
		this.mContext = mContext;
	}

	public abstract int getLayoutId(int viewType);

	@Override
	public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		int layoutId = getLayoutId(viewType);
		if (layoutId == R.layout.fragment_group_recycleview_item1){
			CommonViewHolder commonViewHolder1 = CommonViewHolder.getHolder(mContext,parent,layoutId);
			return commonViewHolder1;
		}
		else {
			CommonViewHolder commonViewHolder2 = CommonViewHolder.getHolder(mContext,parent,layoutId);
			return commonViewHolder2;
		}

	}

	public abstract void convert(CommonViewHolder holder ,int position );

	@Override
	public void onBindViewHolder(CommonViewHolder holder, int position) {
		convert(holder,position);



	}


}

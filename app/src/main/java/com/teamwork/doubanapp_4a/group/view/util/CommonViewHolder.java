package com.teamwork.doubanapp_4a.group.view.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/31.
 */

public class CommonViewHolder extends RecyclerView.ViewHolder {

	private View conveview;
	private SparseArray<View> mViewSparseArray;
	private Context mContext;

	public CommonViewHolder(View itemView) {
		super(itemView);
		conveview = itemView;
		mViewSparseArray = new SparseArray<View>();
	}

	public  View getView(int viewId){
		View view = mViewSparseArray.get(viewId);
		if (view == null){
			view = conveview.findViewById(viewId);
			mViewSparseArray.put(viewId,view);
		}
		return view;
	}
	public static CommonViewHolder getHolder(Context mContext,ViewGroup parent , int layoutId){
		View view = LayoutInflater.from(mContext).inflate(layoutId,parent,false);
		return new CommonViewHolder(view);
	}
	public void setText(int viewId,String s){
		TextView textView = (TextView) getView(viewId);
		textView.setText("发表人: " + s);
	}


}

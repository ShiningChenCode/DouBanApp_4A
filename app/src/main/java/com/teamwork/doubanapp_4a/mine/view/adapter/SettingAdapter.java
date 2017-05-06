package com.teamwork.doubanapp_4a.mine.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */

public class SettingAdapter extends CommonAdapter<String> {

	private List<String> mDatas;
	private static final int HEAD = 1;
	private static final int FOOT = 2;
	private ItemClickListener mItemClickListener;


	public void setItemClickListener(ItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}
	public SettingAdapter(List<String> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
	}

	@Override
	public int getLayoutId(int viewType) {
		if (viewType == HEAD){
			return R.layout.activity_setting_item1;
		}
		return R.layout.activity_setting_item2;

	}

	@Override
	public int getItemViewType(int position) {
		if (position == mDatas.size()){
			return FOOT;
		}
		return HEAD;
	}

	@Override
	public void convert(CommonViewHolder holder, final int position) {
		View view = holder.getView(R.id.view);
		if (position>=0 && position<mDatas.size()){
			TextView contentText = (TextView) holder.getView(R.id.contentText);
			ImageView contentImg = (ImageView) holder.getView(R.id.contentImg);
			contentText.setText(mDatas.get(position));
		}
		if (position == 0 ||position ==2 || position == 5 || position == 6 || position == 8){
			RecyclerView.LayoutParams layoutParam = (RecyclerView.LayoutParams) holder. itemView.getLayoutParams();
			layoutParam.topMargin = 30;
			holder.itemView.setLayoutParams(layoutParam);
		}
		if (position == 1||position == 4||position == 5||position == 7 ||position == 11){
			view.setVisibility(View.INVISIBLE);
		}
		if (position == mDatas.size()){
			RecyclerView.LayoutParams layoutParam = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
			layoutParam.topMargin = 30;
			layoutParam.bottomMargin = 30;
			holder.itemView.setLayoutParams(layoutParam);
		}
		holder.itemView.setOnClickListener(new View.OnClickListener() {
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
		return mDatas.size()+1;
	}
}

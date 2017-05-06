package com.teamwork.doubanapp_4a.mine.view.adapter;

import android.content.Context;
import android.util.Log;
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

public class FuctionAdapter extends CommonAdapter<int[]> {

	private List<int[]> mDatas;
	private int[] Img;
	private Context mContext;
	private String TAG = "ppp";
	private String[] content = {"喜欢","日记","相册","我的广播","电影·电视","读书","音乐","同城活动","豆瓣时间",
			     				"豆列","订单","钱包"};
	private ItemClickListener mItemClickListener;


	public void setItemClickListener(ItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}

	public FuctionAdapter(List<int[]> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
		this.mContext = mContext;
		Img = this.mDatas.get(0);
	}

	@Override
	public int getLayoutId(int viewType) {
		return R.layout.fragment_mine_fuction_item;
	}

	@Override
	public void convert(CommonViewHolder holder, final int position) {
		ImageView contentImg = (ImageView) holder.getView(R.id.contentImg);
		Log.i(TAG, "convert: " + contentImg);
		TextView contentText = (TextView) holder.getView(R.id.contentText);
		contentImg.setBackgroundResource(Img[position]);
		contentText.setText(content[position]);
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
		Log.i(TAG, "getItemCount: " + Img.length);
		return Img.length;
	}
}

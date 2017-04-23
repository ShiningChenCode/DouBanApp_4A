package com.teamwork.doubanapp_4a.group.view.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.groupdata.GroupData;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class GroupAdapter extends CommonAdapter<GroupData> {

	private List<GroupData> mDatas;
	private final static int ONE = 1;
	private final static int TWO = 2;
	private final static int THREE = 3;
	private Context mContext;

	public GroupAdapter(List<GroupData> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
		this.mContext = mContext;
	}

	@Override
	public int getLayoutId(int viewType) {
		if (viewType == ONE) {
			return R.layout.fragment_group_recycleview_item1;
		}
		if (viewType == THREE) {
			return R.layout.fragment_group_recycleview_item3;
		}
		return R.layout.fragment_group_recycleview_item2;
	}

	@Override
	public void convert(CommonViewHolder holder, int position) {
		GroupData groupData = mDatas.get(position);
		Log.i(TAG, "convert: " + "---------" + position);
		if (position == 0 || position == 4 || position == 16 || position == 20 || position == 28
				|| position == 32) {
			Log.i(TAG, "convert:one " + position);
			ImageView topImg = (ImageView) holder.getView(R.id.top_img);
			TextView topText = (TextView) holder.getView(R.id.topText);
			topImg.setImageResource(groupData.getTopImgId());
			topText.setText(groupData.getTopText());
		}
		else if (position == 8 || position == 12 || position == 24 || position == 36 || position == 40
				|| position == 44 || position == 48) {
			TextView lineText = (TextView) holder.getView(R.id.linetext);
			lineText.setText(groupData.getTopText());
			Log.i(TAG, "convert: three " + position);
		}
		else {
			Log.i(TAG, "convert: two" + position);
			ImageView leftImg = (ImageView) holder.getView(R.id.content_img);
			TextView titleText = (TextView) holder.getView(R.id.title_text);
			TextView contentText = (TextView) holder.getView(R.id.content_text);
			TextView numberText = (TextView) holder.getView(R.id.number_text);
			ImageView checkImg = (ImageView) holder.getView(R.id.check_img);
			//leftImg.setImageResource(groupData.getLeftImgId());
			titleText.setText(groupData.getTitleText());
			contentText.setText(groupData.getContentText());
			//Log.i(TAG, "convert: " + "contentText:" + groupData.getContentText());
			numberText.setText(groupData.getNumberText());
			if (!groupData.isSelect()) {
				checkImg.setBackgroundResource(R.drawable.ic_group_check_anonymous);
			} else {
				checkImg.setBackgroundResource(R.drawable.ic_group_checked_anonymous);
			}

		}



	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0 || position == 4 || position == 16 || position == 20 || position == 28
				|| position == 32) {
			return ONE;
		}

		if (position == 8 || position == 12 || position == 24 || position == 36 || position == 40
				|| position == 44 || position == 48) {
			return THREE;

		}
		return TWO;
	}
    String TAG = "aaa";
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
}

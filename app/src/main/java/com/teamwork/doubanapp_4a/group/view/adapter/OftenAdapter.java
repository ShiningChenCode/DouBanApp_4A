package com.teamwork.doubanapp_4a.group.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.groupdata.MorelData;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */

public class OftenAdapter extends CommonAdapter<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> {

	private List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> mData;
	private Context mContext;
	private ItemClickListener mItemClickListener;

	public void setItemClickListener(ItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}

	public OftenAdapter(List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mData = mDatas;
		this.mContext = mContext;
	}

	@Override
	public int getLayoutId(int viewType) {
		return R.layout.frame_group_often;
	}

	private String TAG = "666";
	@Override
	public void convert(CommonViewHolder holder, int position) {
		LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.oftenlayout);
        for (int i=0 ;i<mData.size(); i++){
			final int j = i;
			MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groupsBean = mData.get(i);
			View view = LayoutInflater.from(mContext).inflate(R.layout.frame_group_often_item,linearLayout,false);
			ImageView content_img = (ImageView) view.findViewById(R.id.contentImg);
			TextView titletext = (TextView)view.findViewById(R.id.titletext);
			Glide.with(mContext).load(groupsBean.getAvatar()).into(content_img);
			titletext.setText(groupsBean.getName());
			linearLayout.addView(view);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (mItemClickListener!=null){
						mItemClickListener.onItemClickListener(v,j);
					}
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return 1;
	}
}

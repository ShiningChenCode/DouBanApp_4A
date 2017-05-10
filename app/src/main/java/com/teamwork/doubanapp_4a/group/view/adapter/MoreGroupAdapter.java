package com.teamwork.doubanapp_4a.group.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.view.RecommandActivity;
import com.teamwork.doubanapp_4a.group.view.groupdata.MorelData;
import com.teamwork.doubanapp_4a.group.view.util.CommonAdapter;
import com.teamwork.doubanapp_4a.group.view.util.CommonViewHolder;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class MoreGroupAdapter extends CommonAdapter<MorelData.RecGroupsBean> {

	private List<MorelData.RecGroupsBean> mDatas;
	private final static int HEAD = 1;
	private final static int CONTENT = 2;
	private Context mContext;
	private String TAG = "666";
	private ItemClickListener mItemClickListener;


	public void setItemClickListener(ItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}

	public MoreGroupAdapter(List<MorelData.RecGroupsBean> mDatas, Context mContext) {
		super(mDatas, mContext);
		this.mDatas = mDatas;
		this.mContext = mContext;
	}

	@Override
	public int getItemViewType(int position) {
		int count = 0;
		int first;
		for (int i = 0; i < mDatas.size(); i++) {
			List<MorelData.RecGroupsBean.ClassifiedGroupsBean> classified_groups = mDatas.get(i)
					.getClassified_groups();
			first = i;
			for (int j = 0; j < classified_groups.size(); j++) {
				if (first != 0) {
					count++;
				}
				if (count == position) {
					return HEAD;
				}
				List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> groups =
						classified_groups.get(j).getGroups();
				for (int x = 0; x < groups.size(); x++) {
					count++;
					if (position == count) {
						return CONTENT;
					}
				}
			}
		}
		return super.getItemViewType(position);

	}


	@Override
	public int getLayoutId(int viewType) {
		if (viewType == HEAD) {
			return R.layout.fragment_group_recycleview_head;
		} else return R.layout.fragment_group_recycleview_content;
	}

	@Override
	public void convert(CommonViewHolder holder, final int position) {

	}
	private int selectcount = 0;//选中的个数
	private List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> groupslist = new ArrayList<>();

	private void selectGroup(int position,ImageView check_img) {
		int count = 0;
		int first;
		for (int i = 0; i < mDatas.size(); i++) {
			List<MorelData.RecGroupsBean.ClassifiedGroupsBean> classified_groups = mDatas.get(i)
					.getClassified_groups();
			first = i;
			for (int j = 0; j < classified_groups.size(); j++) {
				List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> groups =
						classified_groups.get(j).getGroups();
				for (int x = 0; x < groups.size(); x++) {
					//点击其他分组里的item count 要做出力 否则位置错乱
					if (first != 0 && x == 0) {
						count++;
					}
					count++;
					if (count == position) {
						MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groupsBean =
								groups.get(x);


						if (!groupsBean.isSelect()) {
							groupsBean.setSelect(true);
							groupslist.add(groupsBean);
							selectcount++;
						} else {
							groupslist.remove(groupsBean);
							groupsBean.setSelect(false);
							selectcount--;
						}
						//第二个参数随便传，不为null就行
						notifyItemChanged(position,1);
						RecommandActivity.changeBtnStatus(selectcount,groupslist);
					}
				}
			}
		}
	}

	//重写三个参数的方法，解决局部刷新单个item 图片会闪一下的问题
	@Override
	public void onBindViewHolder(CommonViewHolder holder, final int position, List<Object> payloads) {
		super.onBindViewHolder(holder, position, payloads);
		Log.i(TAG, "convert: " + position);
		int count = 0;
		int first;
		for (int i = 0; i < mDatas.size(); i++) {
			List<MorelData.RecGroupsBean.ClassifiedGroupsBean> classified_groups = mDatas.get(i)
					.getClassified_groups();
			first = i;
			for (int j = 0; j < classified_groups.size(); j++) {
				if (first != 0) {
					count++;
				}
				if (count == position) {
					TextView titleText = (TextView) holder.getView(R.id.titletext);
					titleText.setText(classified_groups.get(j).getName());

				}
				List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> groups =
						classified_groups.get(j).getGroups();
				for (int x = 0; x < groups.size(); x++) {
					count++;
					if (position == count) {
						MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groupsBean =
								groups.get(x);
						ImageView content_img = (ImageView) holder.getView(R.id.content_img);
						TextView title_text = (TextView) holder.getView(R.id.title_text);
						TextView content_text = (TextView) holder.getView(R.id.content_text);
						TextView number_text = (TextView) holder.getView(R.id.number_text);
						final ImageView check_img = (ImageView) holder.getView(R.id.check_img);


						Glide.with(mContext).load(groupsBean.getAvatar()).into(content_img);

						title_text.setText(groupsBean.getName());
						content_text.setText(groupsBean.getDesc_abstract().trim());
						number_text.setText(groupsBean.getMember_role() + "人");
						if (!groupsBean.isSelect()) {
							check_img.setBackgroundResource(R.drawable.ic_group_check_anonymous);
						} else {
							check_img.setBackgroundResource(R.drawable.ic_group_checked_anonymous);
						}
						RelativeLayout contentRelative = (RelativeLayout) holder.getView(R.id
								.contentRelative);
						contentRelative.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								if (mItemClickListener != null) {
									mItemClickListener.onItemClickListener(v, position);
								}
							}
						});
						check_img.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								selectGroup(position,check_img);
							}
						});
					}
				}
			}
		}

	}

	@Override
	public int getItemCount() {
		int count = 0;
		for (int i = 0; i < mDatas.size(); i++) {
			List<MorelData.RecGroupsBean.ClassifiedGroupsBean> classified_groups = mDatas.get(i)
					.getClassified_groups();
			for (int j = 0; j < classified_groups.size(); j++) {
				count = count + 1;
				count += classified_groups.get(j).getGroups().size();
			}
		}
		return count;
	}

}

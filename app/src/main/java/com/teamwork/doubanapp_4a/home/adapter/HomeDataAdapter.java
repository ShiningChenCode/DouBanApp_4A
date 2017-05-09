package com.teamwork.doubanapp_4a.home.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.home.model.HomeDatas;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页数据
 */

public class HomeDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    HomeDatas homeDatas;
    List<HomeDatas.RecommendFeedsBean> hotDatas = new ArrayList<>();
    List<HomeDatas.RecommendFeedsBean> timeDatas = new ArrayList<>();
    List<HomeDatas.RecommendFeedsBean> amomentDatas = new ArrayList<>();
    private Context mContext;
    public static final int HOT = 0x00;
    public static final int TIME = 0x01;
    public static final int AMOMENT = 0x02;
    public static final int OTHER = 0x03;
    public Boolean isHotTop = true, isTimeTop = true, isAmomentTop = true;
    public int positionHotTop, positionTimeTop, positionAmomentTop;

    public HomeDataAdapter(Context context, HomeDatas homeDatas) {
        this.mContext = context;
        this.homeDatas = homeDatas;

        for (HomeDatas.RecommendFeedsBean bean :
                homeDatas.getRecommend_feeds()
                ) {
            if (null == bean.getCard()) {

            } else if (bean.getCard().getName().equals("热点")) {
                hotDatas.add(bean);
            } else if (bean.getCard().getName().equals("豆瓣时间")) {
                timeDatas.add(bean);
            } else if (bean.getCard().getName().equals("一刻")) {
                amomentDatas.add(bean);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case HOT:

                viewHolder = new MyItemViewHolder(View.inflate(parent.getContext(), R.layout.view_home_hot_data, null));

                break;
            case TIME:
                viewHolder = new MyItemViewHolder(View.inflate(parent.getContext(), R.layout.view_home_hot_data, null));
                break;
            case AMOMENT:
                viewHolder = new MyItemViewHolder(View.inflate(parent.getContext(), R.layout.view_home_hot_data, null));
                break;
            default:
                viewHolder = new MyItemViewHolder(View.inflate(parent.getContext(), R.layout.view_home_hot_data, null));
                break;
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < hotDatas.size()) {
            if (position == positionHotTop) {

                ((MyItemViewHolder) holder).tvTitle.setText(homeDatas.getRecommend_feeds().get(position).getCard().getName());
                ((MyItemViewHolder) holder).recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                ((MyItemViewHolder) holder).recyclerview.setAdapter(new HotDataAdapter(mContext, hotDatas));

            } else {
                ((MyItemViewHolder) holder).llTitle.setVisibility(View.GONE);
            }
        } else if (position >= hotDatas.size() && position < hotDatas.size() + timeDatas.size()) {
            if (position == positionTimeTop) {
                ((MyItemViewHolder) holder).tvTitle.setText(homeDatas.getRecommend_feeds().get(position).getCard().getName());
                ((MyItemViewHolder) holder).recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

                ((MyItemViewHolder) holder).recyclerview.setAdapter(new HotDataAdapter(mContext, amomentDatas));
            } else {
                ((MyItemViewHolder) holder).llTitle.setVisibility(View.GONE);
            }


        } else if (position >= hotDatas.size() + timeDatas.size() && position < hotDatas.size() + timeDatas.size() + amomentDatas.size()) {
            if (position == positionAmomentTop) {
                ((MyItemViewHolder) holder).tvTitle.setText(homeDatas.getRecommend_feeds().get(position).getCard().getName());
                ((MyItemViewHolder) holder).recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                ((MyItemViewHolder) holder).recyclerview.setAdapter(new HotDataAdapter(mContext, amomentDatas));
            } else {
                ((MyItemViewHolder) holder).llTitle.setVisibility(View.GONE);
            }


        }


    }

    @Override
    public int getItemCount() {
        return hotDatas.size() + timeDatas.size() + amomentDatas.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (null == homeDatas.getRecommend_feeds().get(position).getCard()) {
            return OTHER;
        } else if (isHotTop && homeDatas.getRecommend_feeds().get(position).getCard().getName().equals("热点")) {
            isHotTop = false;
            positionHotTop = position;
            return HOT;
        } else if (isTimeTop && homeDatas.getRecommend_feeds().get(position).getCard().getName().equals("豆瓣时间")) {
            isTimeTop = false;
            positionTimeTop = position;
            return TIME;
        } else if (isAmomentTop && homeDatas.getRecommend_feeds().get(position).getCard().getName().equals("一刻")) {
            isAmomentTop = false;
            positionAmomentTop = position;
            return AMOMENT;
        }

        return OTHER;
    }

    class MyItemViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public RecyclerView recyclerview;
        public LinearLayout llTitle;


        public MyItemViewHolder(View itemView) {
            super(itemView);
            recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            llTitle = (LinearLayout) itemView.findViewById(R.id.ll_title);

        }

        private void bindItem() {

        }
    }

}

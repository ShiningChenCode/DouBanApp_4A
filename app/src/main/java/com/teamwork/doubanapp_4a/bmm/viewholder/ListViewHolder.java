package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.IntentUtil;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context mContext;

    public ListViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(MovieBean.ModulesBean modulesBean) {
        String title = modulesBean.getData().getTitle();
        tvTitle.setText(title);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(mContext, DensityUtil.dp2px(mContext, 5)), SpaceItemDecoration.LEFT_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(modulesBean.getData().getSelected_collections()));
    }


    public void bindViewHolder(MovieBean.ModulesBean modulesBean, String title) {
        tvTitle.setText(title);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(mContext, DensityUtil.dp2px(mContext, 5)), SpaceItemDecoration.LEFT_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(modulesBean.getData().getSelected_collections()));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<MovieBean.ModulesBean.DataBean.SelectedCollectionsBean> dataBean;

        public RecyclerViewAdapter(List<MovieBean.ModulesBean.DataBean.SelectedCollectionsBean> dataBean) {
            this.dataBean = dataBean;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_select_list, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ViewHolder viewHolder = null;
            if (holder instanceof ViewHolder) {
                viewHolder = (ViewHolder) holder;
            }
            Glide.with(holder.itemView.getContext()).load(dataBean.get(position).getCovers().get(0)).into(viewHolder.ivLeft);
            Glide.with(holder.itemView.getContext()).load(dataBean.get(position).getCovers().get(1)).into(viewHolder.ivCenter);
            Glide.with(holder.itemView.getContext()).load(dataBean.get(position).getCovers().get(2)).into(viewHolder.ivRight);
            viewHolder.tvContent.setText(dataBean.get(position).getDescription());
            viewHolder.tvTitle.setText(dataBean.get(position).getName());
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor(dataBean.get(position).getBackground_color()));
            viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentUtil.showWebViewIntent((Activity) mContext, dataBean.get(position).getUrl());
                }
            });
        }

        @Override
        public int getItemCount() {
            return null == dataBean ? 0 : dataBean.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivLeft;
            ImageView ivCenter;
            ImageView ivRight;
            TextView tvContent;
            TextView tvTitle;
            CardView cardView;

            public ViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.card_view);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                ivLeft = (ImageView) itemView.findViewById(R.id.iv_left);
                ivCenter = (ImageView) itemView.findViewById(R.id.iv_center);
                ivRight = (ImageView) itemView.findViewById(R.id.iv_right);
            }
        }
    }
}

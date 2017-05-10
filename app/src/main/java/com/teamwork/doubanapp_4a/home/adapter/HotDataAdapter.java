package com.teamwork.doubanapp_4a.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.IntentUtil;
import com.teamwork.doubanapp_4a.home.model.HomeDatas;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

import java.util.List;

/**
 * 首页热点
 */

public class HotDataAdapter extends RecyclerView.Adapter<HotDataAdapter.HotDataHolder> {
    Context mContext;
    List<HomeDatas.RecommendFeedsBean> datas;


    public HotDataAdapter(Context mContext, List<HomeDatas.RecommendFeedsBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public HotDataAdapter.HotDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_hot, parent, false);

        return new HotDataHolder(view);
    }

    @Override
    public void onBindViewHolder(HotDataAdapter.HotDataHolder holder, int position) {
        final HomeDatas.RecommendFeedsBean bean = datas.get(position);
        holder.tvTitle.setText(bean.getTitle());
        holder.tvDesc.setText(bean.getTarget().getDesc());
        holder.tvAuthor.setText(bean.getTarget().getAuthor() == null ? "IDen" : bean.getTarget().getAuthor().getName());
        holder.tvSource.setText(bean.getSource_cn());
        Glide.with(holder.itemView.getContext()).load(bean.getTarget().getCover_url()).into(holder.ivCover);
        holder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1 = bean.getTarget().getUri();
                String[] strs = url1.split("douban://");
                if (strs.length > 1) {
                    url1 = strs[1];
                    url1 = "https://www." + url1;
                } else {
                    url1 = strs[0];
                }

                IntentUtil.showWebViewIntent((Activity) mContext, url1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class HotDataHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlContainer;
        TextView tvTitle, tvDesc, tvAuthor, tvSource;
        ImageView ivCover;

        public HotDataHolder(View itemView) {
            super(itemView);
            rlContainer = (RelativeLayout) itemView.findViewById(R.id.rl_news_container);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            tvSource = (TextView) itemView.findViewById(R.id.tv_source);

            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
        }
    }
}

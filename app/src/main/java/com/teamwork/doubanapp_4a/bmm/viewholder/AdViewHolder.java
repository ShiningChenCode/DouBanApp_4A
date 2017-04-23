package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;

/**
 * Created by admin on 2017/4/23.
 */

public class AdViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    ImageView iv;
    Context context;
    public AdViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        iv = (ImageView) itemView.findViewById(R.id.iv);
    }

    public void bindViewHolder(MovieBean.ModulesBean.DataBean dataBean) {
        tvTitle.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getImage()).into(iv);
    }
}

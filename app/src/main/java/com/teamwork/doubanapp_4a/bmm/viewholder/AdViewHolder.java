package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.broadcast.utils.IntentUtil;

/**
 * Created by admin on 2017/4/23.
 */

public class AdViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    ImageView iv;
    Context mContext;

    public AdViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        iv = (ImageView) itemView.findViewById(R.id.iv);
    }

    public void bindViewHolder(final MovieBean.ModulesBean dataBean) {

        tvTitle.setText(dataBean.getData().getTitle());
        Glide.with(mContext).load(dataBean.getData().getImage()).into(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.showWebViewIntent((Activity) mContext, dataBean.getUri());
            }
        });
    }
}

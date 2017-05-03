package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class TodayViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context context;
    LinearLayout llReadMore;

    public TodayViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        llReadMore = (LinearLayout) itemView.findViewById(R.id.ll_read_more);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(String title) {
        tvTitle.setText(title);
        llReadMore.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(context, 20), SpaceItemDecoration.LEFT_SPACE));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_iv_hr_comment, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tvContent;

            public ViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.iv);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }
    }
}

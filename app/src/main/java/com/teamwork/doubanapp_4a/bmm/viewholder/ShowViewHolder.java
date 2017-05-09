package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.app.Activity;
import android.content.Context;
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
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.IntentUtil;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class ShowViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context mContext;

    public ShowViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(MovieBean.ModulesBean modulesBean) {
        String title = modulesBean.getData().getSubject_collection_boards().get(0).getSubject_collection().getName();
        tvTitle.setText(title);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(mContext,10),SpaceItemDecoration.LEFT_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(modulesBean.getData().getSubject_collection_boards().get(0).getItems()));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<MovieBean.ModulesBean.DataBean.SubjectCollectionBoardsBean.ItemsBean> itemsBeen;

        public RecyclerViewAdapter(List<MovieBean.ModulesBean.DataBean.SubjectCollectionBoardsBean.ItemsBean> itemsBeen) {
            this.itemsBeen = itemsBeen;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ViewHolder viewHolder = null;
            if (holder instanceof ViewHolder) {
                viewHolder = (ViewHolder) holder;
            }
            viewHolder.lldate.setVisibility(View.VISIBLE);
            Glide.with(holder.itemView.getContext()).load(itemsBeen.get(position).getCover().getUrl()).into(viewHolder.iv);
            if (itemsBeen.get(position).getRating() != null) {
                viewHolder.rateNumber.setText(String.valueOf(itemsBeen.get(position).getRating().getValue()));
            }
            viewHolder.tvContent.setText(itemsBeen.get(position).getTitle());
            viewHolder.tvDate.setText(itemsBeen.get(position).getRelease_date());
            viewHolder.tvPersonFav.setVisibility(View.VISIBLE);
            viewHolder.tvPersonFav.setText(itemsBeen.get(position).getWish_count() + "人想看");
            viewHolder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentUtil.showWebViewIntent((Activity) mContext, itemsBeen.get(position).getUrl());
                }
            });
        }

        @Override
        public int getItemCount() {
            return null == itemsBeen ? 0 : itemsBeen.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView rateNumber;
            TextView tvDate;
            TextView tvPersonFav;
            TextView tvContent;
            LinearLayout lldate;

            public ViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.iv);
                rateNumber = (TextView) itemView.findViewById(R.id.rate_number);
                tvDate = (TextView) itemView.findViewById(R.id.tv_date);
                lldate = (LinearLayout) itemView.findViewById(R.id.ll_date);
                tvPersonFav = (TextView) itemView.findViewById(R.id.tv_person_fav);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }
    }
}

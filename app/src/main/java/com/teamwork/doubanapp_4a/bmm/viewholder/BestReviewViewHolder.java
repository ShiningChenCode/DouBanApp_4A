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

public class BestReviewViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvSubTitle;
    RecyclerView recyclerView;
    Context context;
    int size =-1;
    boolean isShowComment = true;
    public BestReviewViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
        tvSubTitle = (TextView) itemView.findViewById(R.id.sub_title);
    }

    public void bindViewHolder(String title) {
        tvTitle.setText(title);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(context, 10), SpaceItemDecoration.TOP_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    public void bindViewHolder(String title,int size) {
        this.size = size;
        tvTitle.setText(title);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(context, 10), SpaceItemDecoration.TOP_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    public void bindViewHolder(String title,String subTitle,boolean isShowComment,String contentTitle) {
        tvTitle.setText(title);
        tvSubTitle.setVisibility(View.VISIBLE);
        tvSubTitle.setText(subTitle);
        this.isShowComment = isShowComment;
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(context, 10), SpaceItemDecoration.TOP_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter recyclerViewAdapter=  new RecyclerViewAdapter(contentTitle);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<MovieSuggestion.ItemsBean> itemsBeen;
        private String title;

        public RecyclerViewAdapter() {
        }

        public RecyclerViewAdapter(List<MovieSuggestion.ItemsBean> items) {
            this.itemsBeen = items;
        }

        public RecyclerViewAdapter(String title) {
            this.title = title;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_item_title_with_iv, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = null;
            if (holder instanceof ViewHolder) {
                viewHolder = (ViewHolder) holder;
            }
            if (!isShowComment){
                viewHolder.tvComment.setVisibility(View.GONE);
                viewHolder.divider.setVisibility(View.GONE);
                viewHolder.tvContent.setText("12319收藏");
                viewHolder.tvTitle.setText(title);
                viewHolder.llThumbnail.setVisibility(View.VISIBLE);
                viewHolder.iv.setVisibility(View.GONE);

            }
            Glide.with(holder.itemView.getContext()).load(R.drawable.ic_movie).into(viewHolder.iv);
        }

        @Override
        public int getItemCount() {
            if (size>0){
                return size;
            }
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tvComment;
            TextView tvContent;
            TextView tvTitle;
            View divider;
            LinearLayout llThumbnail;

            public ViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.iv);
                tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                divider = (View) itemView.findViewById(R.id.divider);
                llThumbnail = (LinearLayout) itemView.findViewById(R.id.ll_thumbnail);
            }
        }
    }
}

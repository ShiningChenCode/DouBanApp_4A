package com.teamwork.doubanapp_4a.broadcast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.model.BroadcastContent;
import com.teamwork.doubanapp_4a.broadcast.model.BroadcastsBean;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;

import java.util.List;

/**
 * Created by Iden on 2017/4/23.
 */

public class BroadcastListAdapter extends RecyclerView.Adapter<BroadcastListAdapter.MyViewHolder> {

    private List<BroadcastsBean.ItemsBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public BroadcastListAdapter(Context context, List<BroadcastsBean.ItemsBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_broadcast_content, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LogUtil.d("mDatas:", mDatas.size() + "");

        BroadcastsBean.ItemsBean.StatusBean status = mDatas.get(position).getStatus();

        //如果是转播的
        if (status != null) {
            Glide.with(mContext).load(status.getAuthor().getAvatar()).transform(new GlideRoundTransform(mContext,30)).into(holder.ivAuthorAvatar);
            holder.tvAuthorName.setText(status.getAuthor().getName());
            holder.tvContent.setText(status.getText());
            holder.tvLikeCount.setText(String.valueOf(status.getLike_count()));
            holder.tvCommentCount.setText(String.valueOf(status.getComments_count()));

            List<BroadcastsBean.ItemsBean.CommentsBean> listComment = mDatas.get(position).getComments();
            if (listComment.size() == 0) {
                holder.llComment.setVisibility(View.GONE);
            }
            if (listComment.size() == 1) {
                holder.llComment2.setVisibility(View.GONE);
                holder.tvCommentAuthor1.setText(listComment.get(0).getAuthor().getName());
                holder.tvCommnetContent1.setText(listComment.get(0).getText());
            }
            if (listComment.size() >= 2) {
                holder.tvCommentAuthor1.setText(listComment.get(0).getAuthor().getName());
                holder.tvCommnetContent1.setText(listComment.get(0).getText());
                holder.tvCommentAuthor2.setText(listComment.get(1).getAuthor().getName());
                holder.tvCommnetContent2.setText(listComment.get(1).getText());
            }
        } else {
            holder.llBroadcast.setVisibility(View.GONE);
            //热门推荐
        }


    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llBroadcast, llComment, llComment2;
        TextView tvAuthorName, tvContent, tvCommentAuthor1, tvCommnetContent1, tvCommentAuthor2, tvCommnetContent2, tvLikeCount, tvCommentCount;
        ImageView ivAuthorAvatar;

        public MyViewHolder(View view) {
            super(view);
            llBroadcast = (LinearLayout) view.findViewById(R.id.ll_broadcast);
            llComment = (LinearLayout) view.findViewById(R.id.ll_comment);
            llComment2 = (LinearLayout) view.findViewById(R.id.ll_comment2);

            tvAuthorName = (TextView) view.findViewById(R.id.tv_author_name);
            tvContent = (TextView) view.findViewById(R.id.tv_content);
            tvCommentAuthor1 = (TextView) view.findViewById(R.id.tv_comment_author1);
            tvCommnetContent1 = (TextView) view.findViewById(R.id.tv_comment_content1);
            tvCommentAuthor2 = (TextView) view.findViewById(R.id.tv_comment_author2);
            tvCommnetContent2 = (TextView) view.findViewById(R.id.tv_comment_content2);
            tvLikeCount = (TextView) view.findViewById(R.id.tv_like_count);
            tvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);

            ivAuthorAvatar = (ImageView) view.findViewById(R.id.iv_author_avatar);
        }

    }
}

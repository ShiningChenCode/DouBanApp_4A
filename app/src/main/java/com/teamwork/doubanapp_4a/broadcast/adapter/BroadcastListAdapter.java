package com.teamwork.doubanapp_4a.broadcast.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.Comment;
import com.teamwork.doubanapp_4a.broadcast.model.Like;
import com.teamwork.doubanapp_4a.broadcast.model.User;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.view.BroadcastDetailActivity;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 广播列表适配
 */

public class BroadcastListAdapter extends RecyclerView.Adapter<BroadcastListAdapter.MyViewHolder> {

    private static SimpleDateFormat DATE_FORMAT_YEAR = new SimpleDateFormat(
            "yyyy年M月d日");
    private static SimpleDateFormat DATE_FORMAT_MONTH = new SimpleDateFormat(
            "M月d日");

    private List<Broadcast> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public BroadcastListAdapter(Context context, List<Broadcast> datas) {
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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        LogUtil.d("mDatas:", mDatas.size() + "");
        holder.tvContent.setText(mDatas.get(position).getContent());
        final BroadcastDataHelper broadcastDataHelper = new BroadcastDataHelper(mContext);
        final Broadcast broadcast = mDatas.get(position);
        final User user = broadcastDataHelper.getUser(broadcast.getUser_id());
        final List<Like> likes = broadcastDataHelper.getLikes(broadcast.getId());

        List<Comment> comments = broadcastDataHelper.getComments(broadcast.getId());
        holder.tvAuthorName.setText(user.getName());
        Glide.with(mContext).load(user.getIcon_url()).transform(new GlideRoundTransform(mContext, 30)).into(holder.ivAuthorAvatar);

        holder.tvReleaseTime.setText(showReleaseTime(broadcast.getTime()));

        holder.tvLikeCount.setText(String.valueOf(likes.size()));
        holder.tvCommentCount.setText(String.valueOf(comments.size()));
        if (comments.size() == 0) {
            holder.llComment.setVisibility(View.GONE);
        }
        if (comments.size() == 1) {
            holder.llComment2.setVisibility(View.GONE);

            holder.tvCommentAuthor1.setText(broadcastDataHelper.getUser(comments.get(0).getUser_id()).getName());
            holder.tvCommnetContent1.setText(comments.get(0).getContent());
        }
        if (comments.size() >= 2) {
            holder.tvCommentAuthor1.setText(broadcastDataHelper.getUser(comments.get(0).getUser_id()).getName());
            holder.tvCommnetContent1.setText(comments.get(0).getContent());
            holder.tvCommentAuthor2.setText(broadcastDataHelper.getUser(comments.get(1).getUser_id()).getName());
            holder.tvCommnetContent2.setText(comments.get(1).getContent());
        }

        holder.llLikeCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastDataHelper.setLike(broadcast.getId(), user.getId());
                holder.tvLikeCount.setText(String.valueOf(broadcastDataHelper.getLikes(broadcast.getId()).size()));

            }
        });

        holder.llCommentCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext, "广播详细页面");
            }
        });

//        BroadcastsBean.ItemsBean.StatusBean status = mDatas.get(position).getStatus();
//
//        //如果是转播的
//        if (status != null) {
//            Glide.with(mContext).load(status.getAuthor().getAvatar()).transform(new GlideRoundTransform(mContext,30)).into(holder.ivAuthorAvatar);
//        } else {
//            holder.llBroadcast.setVisibility(View.GONE);
//            //热门推荐
//        }

        holder.llBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Activity) mContext, BroadcastDetailActivity.class);
                intent.putExtra("broadcast_id", broadcast.getId());
                mContext.startActivity(intent);
            }
        });


    }

    public static String showReleaseTime(long time) {
        long now = System.currentTimeMillis();
        long interval = (now - time) / 1000;
//
        if (interval > 0 && interval < 60) { // 1小时内
            return interval + "秒前";
        } else if (interval > 60 && interval < 3600) {
            return interval / 60 + "分钟前";
        } else if (interval >= 3600 && interval < 3600 * 24) {
            return interval / 3600 + "小时前";
        } else if (new Date(now).getYear() == new Date(time).getYear()) {
            return DATE_FORMAT_MONTH.format(new Date(time));
        }

        return DATE_FORMAT_YEAR.format(new Date(time));
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llBroadcast, llComment, llComment2, llLikeCount, llCommentCount;
        TextView tvAuthorName, tvContent, tvCommentAuthor1, tvCommnetContent1, tvCommentAuthor2, tvCommnetContent2, tvLikeCount, tvCommentCount, tvReleaseTime;
        ImageView ivAuthorAvatar, ivLikeCount;

        public MyViewHolder(View view) {
            super(view);
            llBroadcast = (LinearLayout) view.findViewById(R.id.ll_broadcast);
            llComment = (LinearLayout) view.findViewById(R.id.ll_comment);
            llComment2 = (LinearLayout) view.findViewById(R.id.ll_comment2);
            llLikeCount = (LinearLayout) view.findViewById(R.id.ll_like_count);
            llCommentCount = (LinearLayout) view.findViewById(R.id.ll_comment_count);

            tvAuthorName = (TextView) view.findViewById(R.id.tv_author_name);
            tvContent = (TextView) view.findViewById(R.id.tv_content);
            tvCommentAuthor1 = (TextView) view.findViewById(R.id.tv_comment_author1);
            tvCommnetContent1 = (TextView) view.findViewById(R.id.tv_comment_content1);
            tvCommentAuthor2 = (TextView) view.findViewById(R.id.tv_comment_author2);
            tvCommnetContent2 = (TextView) view.findViewById(R.id.tv_comment_content2);
            tvLikeCount = (TextView) view.findViewById(R.id.tv_like_count);
            tvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);
            tvReleaseTime = (TextView) view.findViewById(R.id.tv_release_time);


            ivAuthorAvatar = (ImageView) view.findViewById(R.id.iv_author_avatar);
            ivLikeCount = (ImageView) view.findViewById(R.id.iv_like_count);
        }

    }
}

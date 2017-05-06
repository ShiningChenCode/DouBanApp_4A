package com.teamwork.doubanapp_4a.broadcast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.Comment;
import com.teamwork.doubanapp_4a.broadcast.model.User;
import com.teamwork.doubanapp_4a.broadcast.utils.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;

import java.util.List;

/**
 * 推荐广播适配
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private List<Comment> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public CommentAdapter(Context context, List<Comment> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public CommentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_comment, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.MyViewHolder holder, int position) {
        Comment comment = mDatas.get(position);
        BroadcastDataHelper broadcastDataHelper = new BroadcastDataHelper(mContext);
        User user = broadcastDataHelper.getUser(comment.getUser_id());
        Glide.with(mContext).load(user.getIcon_url()).transform(new GlideRoundTransform(mContext, 50)).into(holder.ivUser);
        holder.tvUserName.setText(user.getName());
        holder.tvCommentContent.setText(comment.getContent());
        holder.tvReleaseTime.setText(BroadcastListAdapter.showReleaseTime(comment.getTime()));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;
        TextView tvUserName, tvCommentContent, tvReleaseTime;

        public MyViewHolder(View view) {
            super(view);
            ivUser = (ImageView) view.findViewById(R.id.iv_user);
            tvUserName = (TextView) view.findViewById(R.id.tv_comment_author);
            tvCommentContent = (TextView) view.findViewById(R.id.tv_comment_content);
            tvReleaseTime = (TextView) view.findViewById(R.id.tv_release_time);
        }
    }
}

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
import com.teamwork.doubanapp_4a.broadcast.utils.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.model.User;

import java.util.List;

/**
 * 查找豆瓣用户适配
 */

public class SearchUserListAdapter extends RecyclerView.Adapter<SearchUserListAdapter.MyViewHolder> {

    private List<User> mDatas;
    private Context mContext;
    private LayoutInflater inflater;


    public SearchUserListAdapter(Context context, List<User> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public SearchUserListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_broadcast_user_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchUserListAdapter.MyViewHolder holder, int position) {
        User user = mDatas.get(position);
        Glide.with(mContext).load(user.getIcon_url()).transform(new GlideRoundTransform(mContext, 50)).into(holder.ivUser);
        holder.tvUserName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;
        TextView tvUserName;

        public MyViewHolder(View view) {
            super(view);
            ivUser = (ImageView) view.findViewById(R.id.iv_user);
            tvUserName = (TextView) view.findViewById(R.id.tv_user_name);

        }
    }
}

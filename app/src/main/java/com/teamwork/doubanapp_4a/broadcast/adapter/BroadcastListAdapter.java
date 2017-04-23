package com.teamwork.doubanapp_4a.broadcast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.model.BroadcastContent;

import java.util.List;

/**
 * Created by Iden on 2017/4/23.
 */

public class BroadcastListAdapter extends RecyclerView.Adapter<BroadcastListAdapter.MyViewHolder> {

    private List<BroadcastContent> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public BroadcastListAdapter(Context context, List<BroadcastContent> datas) {
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
        holder.tv.setText(mDatas.get(position).getUser().getUserName());
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_username);
        }

    }
}

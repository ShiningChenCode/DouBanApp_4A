package com.teamwork.doubanapp_4a.bmm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.viewholder.AdViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.MovieViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.ShowViewHolder;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class MovieRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MovieBean.ModulesBean> modules;
    public final int TYPE_MOVIE = 0;
    public final int TYPE_OTHER = 1;
    public final int TYPE_AD = 2;
    public final int TYPE_SHOW = 3;
    public final int TYPE_LIST = 4;

    public MovieRecyclerAdapter(List<MovieBean.ModulesBean> modules) {
        this.modules = modules;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == TYPE_MOVIE) {
            viewHolder = new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        } else if (viewType == TYPE_AD) {
            viewHolder = new AdViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_ad, parent, false));
        } else if (viewType == TYPE_SHOW) {
            viewHolder = new ShowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        }else if (viewType == TYPE_SHOW) {
            viewHolder = new ShowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        }else if (viewType == TYPE_LIST) {
            viewHolder = new ShowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieViewHolder) {
            ((MovieViewHolder) holder).bindViewHolder(modules.get(position));
        } else if (holder instanceof AdViewHolder) {
            ((AdViewHolder) holder).bindViewHolder(modules.get(position).getData());
        }else if (holder instanceof ShowViewHolder) {
            ((ShowViewHolder) holder).bindViewHolder(modules.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_MOVIE;
        } else if (position == 1) {
            return TYPE_AD;
        } else if (position == 2) {
            return TYPE_SHOW;
        } else {
            return TYPE_OTHER;
        }
    }
}

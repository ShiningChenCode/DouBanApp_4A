package com.teamwork.doubanapp_4a.bmm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.viewholder.AdViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.BestReviewViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.FlexBoxViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.ListViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.MovieViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.ShowViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.SuggestionViewHolder;

import java.util.ArrayList;
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
    public final int TYPE_SUGGESTION = 5;
    public final int TYPE_BEST_REVIEWS = 6;
    public final int TYPE_FLEX_BOX = 7;
    public final int TYPE_FIND_MOVIE = 8;
    private MovieSuggestion movieSuggestion;

    public MovieRecyclerAdapter(List<MovieBean.ModulesBean> modules) {
        this.modules = modules;
    }

    public MovieRecyclerAdapter(List<MovieBean.ModulesBean> modules, MovieSuggestion movieSuggestion) {
        this.modules = modules;
        this.movieSuggestion = movieSuggestion;
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
        } else if (viewType == TYPE_LIST) {
            viewHolder = new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        } else if (viewType == TYPE_SUGGESTION) {
            viewHolder = new SuggestionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        } else if (viewType == TYPE_BEST_REVIEWS) {
            viewHolder = new BestReviewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        } else if (viewType == TYPE_FIND_MOVIE) {
            viewHolder = new BestReviewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        } else if (viewType == TYPE_FLEX_BOX) {
            viewHolder = new FlexBoxViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (holder instanceof MovieViewHolder) {
            ((MovieViewHolder) holder).bindViewHolder("", modules.get(position));
        } else if (holder instanceof AdViewHolder) {
            ((AdViewHolder) holder).bindViewHolder(modules.get(position).getData());
        } else if (holder instanceof ShowViewHolder) {
            ((ShowViewHolder) holder).bindViewHolder(modules.get(position));
        } else if (holder instanceof ListViewHolder) {
            ((ListViewHolder) holder).bindViewHolder(modules.get(position));
        } else if (holder instanceof SuggestionViewHolder) {
            ((SuggestionViewHolder) holder).bindViewHolder(modules.get(position), movieSuggestion.getItems());
        } else if (holder instanceof BestReviewViewHolder) {
            if (type == TYPE_BEST_REVIEWS) {
                ((BestReviewViewHolder) holder).bindViewHolder("最受欢迎影评");
            } else if (type == TYPE_FIND_MOVIE) {
                ((BestReviewViewHolder) holder).bindViewHolder("发现好电影", "豆瓣网友制作的电影榜单", false, "带你进入不正常的世界");
            }

        } else if (holder instanceof FlexBoxViewHolder) {
            ((FlexBoxViewHolder) holder).bindViewHolder(createFlexData());
        }
    }

    private List<List<String>> createFlexData() {
        List<List<String>> list = new ArrayList<>();
        List<String> itemFrist = new ArrayList<>();
        List<String> itemSecond = new ArrayList<>();
        List<String> itemThird = new ArrayList<>();
        itemFrist.add("经典");
        itemFrist.add("豆瓣高分");
        itemFrist.add("冷门佳片");
        itemSecond.add("剧情");
        itemSecond.add("爱情");
        itemSecond.add("喜剧");
        itemSecond.add("科幻");
        itemSecond.add("动作");
        itemSecond.add("悬疑");
        itemSecond.add("治愈");
        itemSecond.add("文艺");
        itemSecond.add("青春");
        itemThird.add("日本");
        itemThird.add("编辑");
        list.add(itemFrist);
        list.add(itemSecond);
        list.add(itemThird);
        return list;
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_MOVIE;
        } else if (position == 1) {
            return TYPE_AD;
        } else if (position == 2) {
            return TYPE_SHOW;
        } else if (position == 3) {
            return TYPE_LIST;
        } else if (position == 4) {
            return TYPE_SUGGESTION;
        } else if (position == 5) {
            return TYPE_BEST_REVIEWS;
        } else if (position == 6) {
            return TYPE_FLEX_BOX;
        } else if (position == 7) {
            return TYPE_FIND_MOVIE;
        } else {
            return TYPE_OTHER;
        }
    }
}

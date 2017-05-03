package com.teamwork.doubanapp_4a.bmm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.viewholder.AdViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.BestReviewViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.CityViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.ListViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.MovieViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.ShowViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.SuggestionViewHolder;
import com.teamwork.doubanapp_4a.bmm.viewholder.TodayViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class CityRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MovieBean.ModulesBean> modules;
    public final int TYPE_TV_TITLE = 0;
    public final int TYPE_OTHER = 1;
    public final int TYPE_AD = 2;
    public final int TYPE_SHOW = 3;
    public final int TYPE_LIST = 4;
    public final int TYPE_SUGGESTION = 5;
    public final int TYPE_BEST_REVIEWS = 6;
    public final int TYPE_FLEX_BOX = 7;
    public final int TYPE_FIND_MOVIE = 8;
    public final int TYPE_TODAY = 9;
    public final int TYPE_CITY = 10;
    private MovieSuggestion movieSuggestion;

    public CityRecyclerAdapter(List<MovieBean.ModulesBean> modules) {
        this.modules = modules;
    }

    public CityRecyclerAdapter(List<MovieBean.ModulesBean> modules, MovieSuggestion movieSuggestion) {
        this.modules = modules;
        this.movieSuggestion = movieSuggestion;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == TYPE_TV_TITLE) {
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
        } else if (viewType == TYPE_TODAY) {
            viewHolder = new TodayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
        }else if (viewType == TYPE_CITY) {
            viewHolder = new CityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_city_select_item, parent, false));
        }
//        else if (viewType == TYPE_FLEX_BOX) {
//            viewHolder = new FlexBoxViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_rcv_with_title, parent, false));
//        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieViewHolder) {
            if (position == 1) {
                ((MovieViewHolder) holder).bindViewHolder("热门活动", modules.get(0), true,true);
            } else if (position == 2) {
                ((MovieViewHolder) holder).bindViewHolder("官方售票", modules.get(0), true,true);
            } else if (position == 4) {
                ((MovieViewHolder) holder).bindViewHolder("展览类", modules.get(0), true,true);
            } else if (position == 5) {
                ((MovieViewHolder) holder).bindViewHolder("音乐类", modules.get(0), true,true);
            } else if (position == 6) {
                ((MovieViewHolder) holder).bindViewHolder("戏剧类", modules.get(0), true,false);
            } else if (position == 7) {
                ((MovieViewHolder) holder).bindViewHolder("聚会类", modules.get(0), true,false);
            } else if (position == 8) {
                ((MovieViewHolder) holder).bindViewHolder("电影类", modules.get(0), true,false);
            } else if (position == 9) {
                ((MovieViewHolder) holder).bindViewHolder("讲座类", modules.get(0), true,false);
            } else if (position == 10) {
                ((MovieViewHolder) holder).bindViewHolder("课程类", modules.get(0), true,false);
            } else if (position == 11) {
                ((MovieViewHolder) holder).bindViewHolder("旅行类", modules.get(0), true,false);
            } else if (position == 12) {
                ((MovieViewHolder) holder).bindViewHolder("亲子类", modules.get(0), true,false);
            } else if (position == 13) {
                ((MovieViewHolder) holder).bindViewHolder("公益类", modules.get(0), true,false);
            } else if (position == 14) {
                ((MovieViewHolder) holder).bindViewHolder("运动类", modules.get(0), true,false);
            } else if (position == 15) {
                ((MovieViewHolder) holder).bindViewHolder("赛事类", modules.get(0), true,false);
            } else if (holder instanceof ListViewHolder) {
                ((ListViewHolder) holder).bindViewHolder(modules.get(position), "编辑推荐");
            }
        }else if (holder instanceof ListViewHolder) {
            ((ListViewHolder) holder).bindViewHolder(modules.get(3));
        }
//        else if (holder instanceof FlexBoxViewHolder) {
//            ((FlexBoxViewHolder) holder).bindViewHolder(createFlexData());
//        }
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
        return 16;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_CITY;
        } else if (position == 3) {
            return TYPE_LIST;
        } else {
            return TYPE_TV_TITLE;
        }
    }
}

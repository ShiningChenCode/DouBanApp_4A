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

public class SuggestionViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context context;
    LinearLayout llReadMore;

    public SuggestionViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        llReadMore = (LinearLayout) itemView.findViewById(R.id.ll_read_more);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(MovieBean.ModulesBean modulesBean, List<MovieSuggestion.ItemsBean> items) {
        String title = modulesBean.getData().getTitle();
        tvTitle.setText(title);
        llReadMore.setVisibility(View.VISIBLE);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(context, 10), SpaceItemDecoration.LEFT_SPACE));
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.setAdapter(new RecyclerViewAdapter(items));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<MovieSuggestion.ItemsBean> itemsBeen;


        public RecyclerViewAdapter(List<MovieSuggestion.ItemsBean> items) {
            this.itemsBeen = items;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bbm_movie_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = null;
            if (holder instanceof ViewHolder) {
                viewHolder = (ViewHolder) holder;
            }
            Glide.with(holder.itemView.getContext()).load(itemsBeen.get(position).getCover().getUrl()).into(viewHolder.iv);
            if (itemsBeen.get(position).getRating() != null) {
                viewHolder.rateNumber.setText(String.valueOf(itemsBeen.get(position).getRating().getValue()));
            }
            viewHolder.llRate.setVisibility(View.VISIBLE);
            viewHolder.tvContent.setText(itemsBeen.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return null == itemsBeen ? 0 : itemsBeen.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView rateNumber;
            TextView tvContent;
            LinearLayout llRate;

            public ViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.iv);
                rateNumber = (TextView) itemView.findViewById(R.id.rate_number);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
                llRate = (LinearLayout) itemView.findViewById(R.id.ll_rate);
            }
        }
    }
}

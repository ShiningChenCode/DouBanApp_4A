package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.content.Context;
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
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context context;

    public MovieViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);

        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(MovieBean.ModulesBean modulesBean) {
        String title = modulesBean.getData().getSubject_collection_boards().get(0).getSubject_collection().getName();
        tvTitle.setText(title);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(modulesBean.getData().getSubject_collection_boards().get(0).getItems()));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<MovieBean.ModulesBean.DataBean.SubjectCollectionBoardsBean.ItemsBean> itemsBeen;

        public RecyclerViewAdapter(List<MovieBean.ModulesBean.DataBean.SubjectCollectionBoardsBean.ItemsBean> itemsBeen) {
            this.itemsBeen = itemsBeen;
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

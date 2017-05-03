package com.teamwork.doubanapp_4a.bmm.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.FlexboxLayout;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class FlexBoxViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    RecyclerView recyclerView;
    Context context;

    public FlexBoxViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rcv);
        tvTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public void bindViewHolder(List<List<String>> flexData) {
        tvTitle.setText("选电影");
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(context, 10, 1, SpaceItemDecoration.TYPE_DIVIDER, R.color.black);
        recyclerView.addItemDecoration(spaceItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(flexData));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<List<String>> flexData = new ArrayList<>();

        public RecyclerViewAdapter() {

        }

        public RecyclerViewAdapter(List<List<String>> flexData) {
            this.flexData = flexData;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_flex_box, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = null;
            if (holder instanceof ViewHolder) {
                viewHolder = (ViewHolder) holder;
            }
            for (int i = 0; i < flexData.get(position).size(); i++) {
                String name = flexData.get(position).get(i);
                TextView textView = new TextView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(DensityUtil.dp2px(context, 10), 0, 0, 0);
                textView.setPadding(DensityUtil.dp2px(context, 10), DensityUtil.dp2px(context, 10), DensityUtil.dp2px(context, 10), DensityUtil.dp2px(context, 10));
                textView.setText(name);
                textView.setLayoutParams(layoutParams);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textView.setTextColor(context.getResources().getColor(R.color.green_400, null));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.green_400));
                }
                textView.setBackgroundResource(R.drawable.flex_tv_bg);
                viewHolder.flexboxLayout.addView(textView);
            }
        }

        @Override
        public int getItemCount() {
            return flexData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            FlexboxLayout flexboxLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                flexboxLayout = (FlexboxLayout) itemView.findViewById(R.id.flex_box);
            }
        }
    }
}

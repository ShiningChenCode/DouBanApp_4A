package com.teamwork.doubanapp_4a.home.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by XiaGF on 2017/4/23.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=View.inflate(parent.getContext(), R.layout.item_vertical_home,null);
        return new MyItemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyItemViewHolder myItemViewHolder=(MyItemViewHolder)holder;
        myItemViewHolder.bindItem();//进行动态绑定数据
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textView_profile;

        private TextView textView_content;

        private ImageView imageView_news;

        private TextView textView_author;

        private TextView textView_from;
        public MyItemViewHolder(View itemView) {
            super(itemView);
            textView_profile=(TextView)itemView.findViewById(R.id.txt_news_profile);

            textView_content=(TextView)itemView.findViewById(R.id.txt_news_content);

            imageView_news=(ImageView)itemView.findViewById(R.id.img_news);

            textView_author=(TextView)itemView.findViewById(R.id.txt_author);

            textView_from=(TextView)itemView.findViewById(R.id.txt_from);
        }

        private void bindItem(){

        }
    }
}

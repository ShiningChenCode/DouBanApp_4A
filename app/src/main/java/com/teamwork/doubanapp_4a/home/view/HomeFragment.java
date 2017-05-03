package com.teamwork.doubanapp_4a.home.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.home.adapter.MyAdapter;
import com.teamwork.doubanapp_4a.home.control.DividerItemDecoration;
import com.teamwork.doubanapp_4a.home.util.GlideImageLoader;
import com.teamwork.doubanapp_4a.home.util.Util;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  implements SwipeRefreshLayout.OnRefreshListener{
    private Banner mBanner;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView mRecyclerView;

    private ScrollView mScrollView;

    private MyAdapter myAdapter;

    private LinearLayoutManager mLinearLayoutManager;




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        mSwipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.id_swiperefreshlayout);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        mScrollView=(ScrollView)view.findViewById(R.id.slv_container);
        //View banner=inflater.inflate(R.layout.head_banner_home,container,false);
        mBanner=(Banner)view.findViewById(R.id.banner_home);
        return view;
    }

    private void setBanner(){
        String[] urls=getResources().getStringArray(R.array.url);
        List images= Arrays.asList(urls);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
       // mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播,默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setBanner();
        solveConflict();
        mLinearLayoutManager=new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        myAdapter=new MyAdapter(getContext());
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), Util.dp2px(getContext(),10)));

    }

    @Override
    public void onRefresh() {

    }

    private void solveConflict(){
        if(mScrollView!=null) {
            mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    if(mSwipeRefreshLayout!=null){
                        mSwipeRefreshLayout.setEnabled(mScrollView.getScrollY()==0);
                    }

                }
            });
        }
    }
}

package com.teamwork.doubanapp_4a.home.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.IntentUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.home.adapter.HomeDataAdapter;
import com.teamwork.doubanapp_4a.home.control.DividerItemDecoration;
import com.teamwork.doubanapp_4a.home.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.home.model.BannerDatas;
import com.teamwork.doubanapp_4a.home.model.HomeDatas;
import com.teamwork.doubanapp_4a.home.presenter.HomePresenter;
import com.teamwork.doubanapp_4a.home.util.GlideImageLoader;
import com.teamwork.doubanapp_4a.home.util.Util;
import com.teamwork.doubanapp_4a.main.base.BaseFragment;
import com.teamwork.doubanapp_4a.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OnGetDataListener<BannerDatas, HomeDatas> {
    Context mContext;
    private Banner mBanner;
    private RecyclerView mRecyclerView;
    private NestedScrollView mScrollView;
    private ProgressBar mBannerProgressBar, mRecyclerProgressBar;
    private HomeDataAdapter myAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private TextView tvFailed;
    private SwipeRefreshLayout swiperefresh;
    private HomePresenter presenter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        presenter = new HomePresenter(mContext, this);
        presenter.getBanner();
        presenter.getHomeDatas();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getContext();
        initViews(view);


        return view;
    }

    private void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mScrollView = (NestedScrollView) view.findViewById(R.id.slv_container);
        //View banner=inflater.inflate(R.layout.head_banner_home,container,false);
        mBanner = (Banner) view.findViewById(R.id.banner_home);
        mBannerProgressBar = (ProgressBar) view.findViewById(R.id.banner_progressbar);
        mRecyclerProgressBar = (ProgressBar) view.findViewById(R.id.recyler_progressbar);
        tvFailed = (TextView) view.findViewById(R.id.tv_failed);
        swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        tvFailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLinearLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //下拉刷新
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refresh();

            }
        });

        mScrollView.setFocusable(false);

        swiperefresh.setFocusable(true);

    }


    @Override
    public void gettingBanner() {
        loadingBanner();
    }


    @Override
    public void getBannerSuccess(final BannerDatas data) {
        showBanner();
        List images = new ArrayList();
        for (BannerDatas.PromosBean bean : data.getPromos()
                ) {
            images.add(bean.getImage());

        }
        setBanner(data, images);


    }

    private void setBanner(final BannerDatas data, List images) {
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
        mBanner.setDelayTime(3000);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);

        mBanner.setFocusable(true);
        mBanner.setFocusableInTouchMode(true);
        mBanner.requestFocus();
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                IntentUtil.showWebViewIntent((Activity) mContext, data.getPromos().get(position).getUri());
            }
        });
    }

    @Override
    public void getBannerFailed(String msg) {
        showFailed(msg);
    }


    @Override
    public void gettingHomeDatas() {

        loadingHomeDatas();

    }


    @Override
    public void getHomeDatasSuccess(HomeDatas data) {
        showHomeDatas();
        LogUtil.d("getHomeDatasSuccess", data.getRecommend_feeds().size() + "");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new HomeDataAdapter(mContext, data);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), Util.dp2px(getContext(), 10)));

    }

    @Override
    public void getHomeDatasFailed(String msg) {
        showFailed(msg);
    }

    private void loadingBanner() {
        tvFailed.setVisibility(View.GONE);
        mBannerProgressBar.setVisibility(View.VISIBLE);
        mBanner.setVisibility(View.GONE);
    }

    private void loadingHomeDatas() {
        tvFailed.setVisibility(View.GONE);
        mRecyclerProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }


    private void showBanner() {
        swiperefresh.setRefreshing(false);
        tvFailed.setVisibility(View.GONE);
        mBannerProgressBar.setVisibility(View.GONE);
        mBanner.setVisibility(View.VISIBLE);
    }

    private void showHomeDatas() {
        swiperefresh.setRefreshing(false);
        tvFailed.setVisibility(View.GONE);
        mRecyclerProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showFailed(String msg) {
        swiperefresh.setRefreshing(false);
        tvFailed.setText(msg);
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRefresh() {

    }

    private void refresh() {
        presenter.getBanner();
        presenter.getHomeDatas();
    }

}

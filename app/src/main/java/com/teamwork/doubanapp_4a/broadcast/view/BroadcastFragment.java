package com.teamwork.doubanapp_4a.broadcast.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.broadcast.presenter.BroadcastPresenter;
import com.teamwork.doubanapp_4a.broadcast.utils.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.adapter.BroadcastListAdapter;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.BroadcastsBean;
import com.teamwork.doubanapp_4a.broadcast.utils.FileUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.IntentUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.SqliteHelper;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 广播界面
 */
public class BroadcastFragment extends Fragment implements View.OnClickListener, OnGetDataListener<List<Broadcast>> {

    Context mContext;
    Toolbar toolbar;
    ImageView ivUser, ivSearchUser, ivChat, ivCapturePhotos;
    LinearLayout llSendBroadcast;
    Button btnFindMore;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    SwipeRefreshLayout swiperefresh;
    LinearLayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ScrollView scrollView;
    OnChangeFragmentListener mCallback;
    BroadcastPresenter broadcastPresenter;


    public BroadcastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_broadcast, container, false);
        mContext = getContext();

        broadcastPresenter = new BroadcastPresenter(mContext, this);
        initViews(view);
        bindListener();


        //Fragment中设置ToolBar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //Fragment中设置ToolBar Menu
        setHasOptionsMenu(true);

        initRecyclerView();
        broadcastPresenter.getBroadcasts();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (OnChangeFragmentListener) activity;
    }


    private void initViews(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ivUser = (ImageView) view.findViewById(R.id.iv_user);
        ivSearchUser = (ImageView) view.findViewById(R.id.iv_search_user);
        ivChat = (ImageView) view.findViewById(R.id.iv_chat);
        ivCapturePhotos = (ImageView) view.findViewById(R.id.iv_capture_photos);
        llSendBroadcast = (LinearLayout) view.findViewById(R.id.ll_send_broadcast);
        btnFindMore = (Button) view.findViewById(R.id.btn_find_more);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        scrollView = (ScrollView) view.findViewById(R.id.scrollview);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        Glide.with(mContext).load("https://qnmob2.doubanio.com/icon/ur49215882-22.jpg?imageView2/2/q/80/w/640/h/640/format/webp").transform(new GlideRoundTransform(mContext, 30)).into(ivUser);
    }

    private void bindListener() {
        ivSearchUser.setOnClickListener(this);
        ivChat.setOnClickListener(this);
        ivCapturePhotos.setOnClickListener(this);
        llSendBroadcast.setOnClickListener(this);
        btnFindMore.setOnClickListener(this);
        recyclerView.setOnClickListener(this);
    }

    private void initRecyclerView() {


        layoutManager = new LinearLayoutManager(mContext);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);


        //下拉刷新
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                pullDownRefreshData();

            }
        });

        scrollView.setFocusable(false);

        swiperefresh.setFocusable(true);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Log.d("onScrollChanged", layoutManager.findLastVisibleItemPosition() + "");
                swiperefresh.setEnabled(scrollView.getScrollY() == 0);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search_user:
                ToastUtil.showShort(mContext, "查找用户");
                IntentUtil.showIntent((Activity) mContext, SearchUserActivity.class);
                break;
            case R.id.iv_chat:
                ToastUtil.showShort(mContext, "聊天窗口");
                break;
            case R.id.ll_send_broadcast:
                ToastUtil.showShort(mContext, "发送广播");
                IntentUtil.showIntent((Activity) mContext, SendBroadcastActivity.class);
                break;
            case R.id.iv_capture_photos:
                ToastUtil.showShort(mContext, "添加照片");
                break;
            case R.id.btn_find_more:
                ToastUtil.showShort(mContext, "发现更多");
                mCallback.changeToRecomentBroadcast();

                break;
        }

    }

    @Override
    public void gettingData() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void getDataSuccess(List<Broadcast> data) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter = new BroadcastListAdapter(mContext, data);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void getDataFailed() {

    }

    @Override
    public void refreshData() {


    }

    @Override
    public void pullDownRefreshData() {
        broadcastPresenter.pullDownRefreshBroadcasts();

    }

    @Override
    public void pullDownRefreshSuccess(List<Broadcast> data) {
        swiperefresh.setRefreshing(false);
        adapter = new BroadcastListAdapter(mContext, data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void pullDownRefreshFailed() {

    }

    public interface OnChangeFragmentListener {
        abstract void changeToRecomentBroadcast();

        abstract void changeToBroadcast();
    }

}

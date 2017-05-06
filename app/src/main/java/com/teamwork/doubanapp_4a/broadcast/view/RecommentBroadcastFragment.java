package com.teamwork.doubanapp_4a.broadcast.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.adapter.BroadcastListAdapter;
import com.teamwork.doubanapp_4a.broadcast.adapter.RecomentBroadcastAdapter;
import com.teamwork.doubanapp_4a.broadcast.adapter.SearchUserListAdapter;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.utils.GridSpacingItemDecoration;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.IntentUtil;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommentBroadcastFragment extends Fragment implements View.OnClickListener {
    Context mContext;
    Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<Broadcast> mDatas;
    BroadcastFragment.OnChangeFragmentListener mCallback;
    ImageView ivBarBack, ivSearchUser, ivChat;

    public RecommentBroadcastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        mCallback = (BroadcastFragment.OnChangeFragmentListener) mContext;
        View view = inflater.inflate(R.layout.fragment_recomment_broadcast, container, false);
        initViews(view);

        initRecyleView();
        bindListeners();
        return view;
    }


    private void initViews(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        ivBarBack = (ImageView) view.findViewById(R.id.iv_bar_back);
        ivChat = (ImageView) view.findViewById(R.id.iv_chat);
        ivSearchUser = (ImageView) view.findViewById(R.id.iv_search_user);


    }


    private void bindListeners() {
        ivSearchUser.setOnClickListener(this);
        ivChat.setOnClickListener(this);
        ivBarBack.setOnClickListener(this);
    }

    private void initRecyleView() {
        mDatas = new ArrayList<>();
        mDatas = new BroadcastDataHelper(mContext).getBroadcasts();
        adapter = new RecomentBroadcastAdapter(mContext, mDatas);
        layoutManager = new GridLayoutManager(mContext, 1);

        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);

        int spanCount = 1; // 3 columns
        int spacing = 40; // 50px
        boolean includeEdge = false;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

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
            case R.id.iv_bar_back:
                ToastUtil.showShort(mContext, "返回广播");
                mCallback.changeToBroadcast();
                break;
            case R.id.iv_close:
                ToastUtil.showShort(mContext, "关闭广播");
                break;
            case R.id.btn_follow:
                ToastUtil.showShort(mContext, "关注");
                break;
        }

    }
}

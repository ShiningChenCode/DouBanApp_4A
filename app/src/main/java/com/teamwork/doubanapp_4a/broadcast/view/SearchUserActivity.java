package com.teamwork.doubanapp_4a.broadcast.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.adapter.SearchUserListAdapter;
import com.teamwork.doubanapp_4a.broadcast.model.User;
import com.teamwork.doubanapp_4a.broadcast.utils.GridSpacingItemDecoration;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchUserActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> mDatas;
    GridLayoutManager layoutManager;
    Button btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        mContext = this;
        initViews();
        setSupportActionBar(toolbar);
        bindListeners();
        initRecyleView();

    }

    private void bindListeners() {
        btnCancle.setOnClickListener(this);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        btnCancle = (Button) findViewById(R.id.btn_cancle);
    }


    private void initRecyleView() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add(new BroadcastDataHelper(mContext).getUser(1));
        }
        layoutManager = new GridLayoutManager(mContext, 2);

        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SearchUserListAdapter(mContext, mDatas);


        recyclerView.setAdapter(adapter);

        int spanCount = 2; // 3 columns
        int spacing = 40; // 50px
        boolean includeEdge = false;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancle:
                ((Activity) mContext).finish();
                break;
        }
    }
}

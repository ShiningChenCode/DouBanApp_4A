package com.teamwork.doubanapp_4a.broadcast.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.adapter.BroadcastListAdapter;
import com.teamwork.doubanapp_4a.broadcast.adapter.CommentAdapter;
import com.teamwork.doubanapp_4a.broadcast.adapter.RecomentBroadcastAdapter;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.Comment;
import com.teamwork.doubanapp_4a.broadcast.model.User;
import com.teamwork.doubanapp_4a.broadcast.utils.GlideRoundTransform;
import com.teamwork.doubanapp_4a.broadcast.utils.GridSpacingItemDecoration;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.IntentUtil;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.recyclerview.R.attr.layoutManager;

public class BroadcastDetailActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    int broadcast_id = 2;
    BroadcastDataHelper broadcastDataHelper;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    GridLayoutManager layoutManager;
    Broadcast broadcast;
    List<Comment> mDatas;


    ImageView ivBarBack, ivAuthorAvatar;
    TextView tvtAuthorName, tvReleaseTime, tvContent;
    LinearLayout llComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_detail);
        mContext = this;
        broadcast_id = getIntent().getExtras().getInt("broadcast_id");
        broadcastDataHelper = new BroadcastDataHelper(mContext);
        broadcast = broadcastDataHelper.getBroadcast(broadcast_id);
        initViews();

        initRecyleView();
    }

    private void initViews() {
        tvtAuthorName = (TextView) findViewById(R.id.tv_author_name);
        tvReleaseTime = (TextView) findViewById(R.id.tv_release_time);
        tvContent = (TextView) findViewById(R.id.tv_content);

        ivBarBack = (ImageView) findViewById(R.id.iv_bar_back);
        ivAuthorAvatar = (ImageView) findViewById(R.id.iv_author_avatar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        llComment = (LinearLayout) findViewById(R.id.ll_comment);

        int userId = broadcast.getUser_id();
        User user = broadcastDataHelper.getUser(userId);
        tvtAuthorName.setText(user.getName());
        tvContent.setText(broadcast.getContent());
        Glide.with(mContext).load(user.getIcon_url()).transform(new GlideRoundTransform(mContext, 25)).into(ivAuthorAvatar);

        tvReleaseTime.setText(BroadcastListAdapter.showReleaseTime(broadcast.getTime()));
        ivBarBack.setOnClickListener(this);
        llComment.setOnClickListener(this);
    }


    private void initRecyleView() {
        mDatas = new ArrayList<>();
        mDatas = broadcastDataHelper.getComments(broadcast.getId());
        adapter = new CommentAdapter(mContext, mDatas);
        layoutManager = new GridLayoutManager(mContext, 1);

        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);

        int spanCount = 1; // 3 columns
        int spacing = 1; // 50px
        boolean includeEdge = false;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_bar_back:
                ((Activity) mContext).finish();
                break;
            case R.id.ll_comment:
                Intent intent = new Intent((Activity) mContext, EditCommentActivity.class);
                intent.putExtra("broadcast_id", broadcast_id);
                startActivity(intent);
                break;
        }
    }
}

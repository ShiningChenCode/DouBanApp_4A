package com.teamwork.doubanapp_4a.group.view.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.adapter.MoreGroupAdapter;
import com.teamwork.doubanapp_4a.group.view.db.MySqlite;
import com.teamwork.doubanapp_4a.group.view.groupdata.MorelData;
import com.teamwork.doubanapp_4a.group.view.lookcontract.LookContract;
import com.teamwork.doubanapp_4a.group.view.presenter.LookPresenter;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;

import java.util.List;

public  class RecommandActivity extends AppCompatActivity implements View.OnClickListener,LookContract.ILookView<MorelData.RecGroupsBean> {

	private RecyclerView groupRecycleView;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private ImageView back_img;
	private ImageView refresh_img;
	private static Button select_btn;
	private MorelData mMorelData;
	private MoreGroupAdapter mMoreAdapter;
	private static List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> grouplists;
	private MySqlite mSqlite;
	private SQLiteDatabase database;
	private LookPresenter mLookPresenter;
	private final static String moregroupsUrl = "http://60.205.189.201/douban/group/moregroups.php";
	private ProgressBar waitbar;
	String TAG = "hhh";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommand);
		mLookPresenter = new LookPresenter(this);
		mSqlite = new MySqlite(this,"Group.db",null,1);
		database = mSqlite.getWritableDatabase();
		initView();
		mLookPresenter.look(moregroupsUrl);
	}


	private void initView() {
		groupRecycleView = (RecyclerView) findViewById(R.id.grouprecycleview);
		groupRecycleView.setNestedScrollingEnabled(false);
		back_img = (ImageView) findViewById(R.id.back_img);
		refresh_img = (ImageView) findViewById(R.id.refresh_img);
		select_btn = (Button) findViewById(R.id.select_btn);
		waitbar = (ProgressBar) findViewById(R.id.waitbar);
		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
		mSwipeRefreshLayout.setColorSchemeResources(R.color.green_400);
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Log.i(TAG, "run: " + "-----------");
						//mMoreAdapter.notifyDataSetChanged();
						Toast.makeText(RecommandActivity.this,"刷新完成",Toast.LENGTH_SHORT).show();
						mSwipeRefreshLayout.setRefreshing(false);
					}
				},2000);
			}
		});
		back_img.setOnClickListener(this);
		refresh_img.setOnClickListener(this);
		select_btn.setOnClickListener(this);

	}
	public static void changeBtnStatus(int selectcount, List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> grouplist){
			if (selectcount>0){
			select_btn.setBackgroundResource(R.color.green_400);
		}else {
			select_btn.setBackgroundResource(R.color.grey_400);
		}
		grouplists = grouplist;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.back_img:
				finish();
				break;
			case R.id.refresh_img:
				break;
			case R.id.select_btn:
				for (MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groups : grouplists){
					ContentValues content = new ContentValues();
					content.put(MySqlite.Img_url,groups.getAvatar());
					content.put(MySqlite.Title_text,groups.getName());
					content.put(MySqlite.Detail_url,groups.getUrl());
					database.insert(MySqlite.table_name,null,content);
				}
				finish();
				break;
		}

	}


	@Override
	public void showLook(final List<MorelData.RecGroupsBean> data) {
		mMoreAdapter = new MoreGroupAdapter(data,this);
		groupRecycleView.setLayoutManager(new LinearLayoutManager(this));
		groupRecycleView.setAdapter(mMoreAdapter);
		mMoreAdapter.setItemClickListener(new ItemClickListener() {
			@Override
			public void onItemClickListener(View v, int position) {
				int count = 0;
				int first;
				for (int i = 0; i < data.size(); i++) {
					List<MorelData.RecGroupsBean.ClassifiedGroupsBean> classified_groups = data.get(i)
							.getClassified_groups();
					first = i;
					for (int j = 0; j < classified_groups.size(); j++) {
						List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> groups =
								classified_groups.get(j).getGroups();
						for (int x = 0; x < groups.size(); x++) {
							//点击其他分组里的item count 要做出力 否则位置错乱
							if (first!=0 && x == 0){
								count++;
							}
							count++;
							Log.i(TAG, "onItemClickListener: " + "count:" + count + "position:" + position);
							if (position == count) {
								Log.i(TAG, "getItemViewType: " + "count");
								MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groupsBean
										= groups.get(x);
								String url = groupsBean.getUrl();
								String imgUrl = groupsBean.getAvatar();
								String content = groupsBean.getName();
								Intent intent = new Intent(RecommandActivity.this,DetailActivity.class);
								intent.putExtra("url",url);
								intent.putExtra("imgUrl",imgUrl);
								intent.putExtra("content_text",content);
								startActivity(intent);
							}
						}
					}
				}
			}
		});

	}

	@Override
	public void showFailed() {

	}

	@Override
	public void showProgress() {
		Log.i(TAG, "showProgress: " + "--------------");
		waitbar.setVisibility(View.VISIBLE);

	}

	@Override
	public void hideProgress() {
		Log.i(TAG, "hideProgress: " + "------------");
		waitbar.setVisibility(View.GONE);
	}
}

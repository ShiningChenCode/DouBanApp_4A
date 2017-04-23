package com.teamwork.doubanapp_4a.group.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.adapter.GroupAdapter;
import com.teamwork.doubanapp_4a.group.view.groupdata.GroupData;

import java.util.ArrayList;
import java.util.List;

public class RecommandActivity extends AppCompatActivity implements View.OnClickListener {

	private RecyclerView groupRecycleView;
	private ImageView back_img;
	private ImageView refresh_img;
	private Button select_btn;
	private List<GroupData> mGroupDataList;
	private GroupAdapter mGroupAdapter;
	String TAG = "hhh";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommand);
		Log.i(TAG, "onCreate: " + "---------------");
		initView();
		initData();
	}

	private void initView() {
		groupRecycleView = (RecyclerView) findViewById(R.id.grouprecycleview);
		back_img = (ImageView) findViewById(R.id.back_img);
		refresh_img = (ImageView) findViewById(R.id.refresh_img);
		select_btn = (Button) findViewById(R.id.select_btn);
		back_img.setOnClickListener(this);
		refresh_img.setOnClickListener(this);
		select_btn.setOnClickListener(this);
		mGroupDataList = new ArrayList<GroupData>();
	}


	private void initData() {
		for (int i = 0; i < 52; i++) {
			GroupData groupData = new GroupData();
			groupData.setTopImgId(R.drawable.bg_player_default);
			groupData.setTopText(i + "");
			groupData.setLeftImgId(R.drawable.bg_player_default);
			groupData.setTitleText(i + "");
			groupData.setContentText(i + "");
			groupData.setNumberText(i + "人");
			groupData.setSelect(false);
			mGroupDataList.add(groupData);
		}
		mGroupAdapter = new GroupAdapter(mGroupDataList, this);
		groupRecycleView.setLayoutManager(new LinearLayoutManager(this) {
			@Override
			public boolean canScrollVertically() {
				//禁止recycleview滑动，scrollview嵌套recycleview 会使滑动卡顿
				return false;
			}
		});
		groupRecycleView.setAdapter(mGroupAdapter);
		Log.i(TAG, "initData: " + "-------------------------------");
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
				break;
		}

	}
}

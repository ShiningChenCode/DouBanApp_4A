package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.SettingAdapter;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private SettingAdapter settingAdapter;
	private List<String> content = new ArrayList<>();
	private BaseTitle mBaseTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		initView();
		initData();
		settingAdapter = new SettingAdapter(content,this);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(settingAdapter);
	}

	private void initData() {
		content.add("推送");
		content.add("兴趣标签");
		content.add("绑定微信");
		content.add("绑定手机号");
		content.add("修改密码");
		content.add("清楚缓存");
		content.add("将小组放在桌面");
		content.add("帮助与反馈");
		content.add("网络诊断");
		content.add("新功能介绍");
		content.add("关于");
		content.add("开源许可");
	}

	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mBaseTitle.setTitle("设置");
		mRecyclerView = (RecyclerView) findViewById(R.id.settingrecy);
	}
}

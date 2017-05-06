package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.DouBanTimeAdapter;
import com.teamwork.doubanapp_4a.mine.view.adapter.LocalAdapter;
import com.teamwork.doubanapp_4a.mine.view.doubanfragment.DownLoad;
import com.teamwork.doubanapp_4a.mine.view.doubanfragment.Subscription;


import java.util.ArrayList;
import java.util.List;

public class DouBanTimeActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	private DouBanTimeAdapter mDouBanTimeAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dou_ban_time);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("豆瓣时间");
	}
	public void initData(){
		title.add("我的订阅");
		title.add("我的下载");
		mFragmentList.add(new Subscription());
		mFragmentList.add(new DownLoad());
		mDouBanTimeAdapter = new DouBanTimeAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mDouBanTimeAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}
}

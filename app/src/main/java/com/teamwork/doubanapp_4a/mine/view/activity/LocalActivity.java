package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.LocalAdapter;
import com.teamwork.doubanapp_4a.mine.view.localfragment.Interested;
import com.teamwork.doubanapp_4a.mine.view.localfragment.Join;

import java.util.ArrayList;
import java.util.List;

public class LocalActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	private LocalAdapter mLocalAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("同城活动");
	}
	public void initData(){
		title.add("感兴趣");
		title.add("要参加");
		mFragmentList.add(new Interested());
		mFragmentList.add(new Join());
		mLocalAdapter = new LocalAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mLocalAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}
}

package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.ReadAdapter;
import com.teamwork.doubanapp_4a.mine.view.readfragment.BookReview;
import com.teamwork.doubanapp_4a.mine.view.readfragment.DuGuo;
import com.teamwork.doubanapp_4a.mine.view.readfragment.Note;
import com.teamwork.doubanapp_4a.mine.view.readfragment.Reading;
import com.teamwork.doubanapp_4a.mine.view.readfragment.WantRead;

import java.util.ArrayList;
import java.util.List;

public class ReadingActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	private ReadAdapter mReadAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("读书");
	}
	public void initData(){
		title.add("想读");
		title.add("在读");
		title.add("读过");
		title.add("书评");
		title.add("笔记");
		mFragmentList.add(new WantRead());
		mFragmentList.add(new Reading());
		mFragmentList.add(new DuGuo());
		mFragmentList.add(new BookReview());
		mFragmentList.add(new Note());
		mReadAdapter = new ReadAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mReadAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}
}

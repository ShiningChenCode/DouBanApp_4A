package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.MusicAdapter;
import com.teamwork.doubanapp_4a.mine.view.readfragment.BookReview;
import com.teamwork.doubanapp_4a.mine.view.readfragment.DuGuo;
import com.teamwork.doubanapp_4a.mine.view.readfragment.Reading;
import com.teamwork.doubanapp_4a.mine.view.readfragment.WantRead;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	private MusicAdapter mMusicAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("音乐");
	}
	public void initData(){
		title.add("想听");
		title.add("在听");
		title.add("听过");
		title.add("乐评");
		mFragmentList.add(new WantRead());
		mFragmentList.add(new Reading());
		mFragmentList.add(new DuGuo());
		mFragmentList.add(new BookReview());
		mMusicAdapter = new MusicAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mMusicAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}
}

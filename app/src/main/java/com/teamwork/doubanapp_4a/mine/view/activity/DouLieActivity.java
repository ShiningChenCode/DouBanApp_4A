package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.DouLieAdapter;
import com.teamwork.doubanapp_4a.mine.view.doulie.Collect;
import com.teamwork.doubanapp_4a.mine.view.doulie.Create;

import java.util.ArrayList;
import java.util.List;

public class DouLieActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	private DouLieAdapter mDouLieAdapter;
	private String TAG = "666";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dou_lie);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("豆列");
		mBaseTitle.setTextTitle("创建");
		mBaseTitle.showText();
		mBaseTitle.setBtnBackGround(R.color.douban_white);
	}
	public void initData(){
		title.add("我创建的都列");
		title.add("我收藏的豆列");
		mFragmentList.add(new Create());
		mFragmentList.add(new Collect());
		mDouLieAdapter = new DouLieAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mDouLieAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
		mViewPager.addOnPageChangeListener(this);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		if (position == 0){
			mBaseTitle.showText();
		}else {
			mBaseTitle.hideText();
		}

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}

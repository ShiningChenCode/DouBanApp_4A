package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.mine.view.adapter.MovieAdapter;
import com.teamwork.doubanapp_4a.mine.view.moviefragment.KanGuo;
import com.teamwork.doubanapp_4a.mine.view.moviefragment.MoviePeople;
import com.teamwork.doubanapp_4a.mine.view.moviefragment.MovieReview;
import com.teamwork.doubanapp_4a.mine.view.moviefragment.Seeing;
import com.teamwork.doubanapp_4a.mine.view.moviefragment.WantSee;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private MovieAdapter mMovieAdapter;
	private List<String> title = new ArrayList<>();
	private List<Fragment> mFragmentList = new ArrayList<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie);
		initView();
		initData();
	}
	private void initView() {
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mBaseTitle.setTitle("电影·电视");
	}
	public void initData(){
		title.add("想看");
		title.add("在看");
		title.add("看过");
		title.add("影评");
		title.add("影人");
		mFragmentList.add(new WantSee());
		mFragmentList.add(new Seeing());
		mFragmentList.add(new KanGuo());
		mFragmentList.add(new MovieReview());
		mFragmentList.add(new MoviePeople());
		mMovieAdapter = new MovieAdapter(getSupportFragmentManager(),title,mFragmentList);
		mViewPager.setAdapter(mMovieAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}
}

package com.teamwork.doubanapp_4a.mine.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ReadAdapter extends FragmentPagerAdapter {
	private List<String> title;
	private List<Fragment> mFragmentList;
	public ReadAdapter(FragmentManager fm,List<String> title,List<Fragment> mFragmentList) {
		super(fm);
		this.title = title;
		this.mFragmentList = mFragmentList;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}

	@Override
	public int getCount() {
		return title.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return title.get(position);
	}
}

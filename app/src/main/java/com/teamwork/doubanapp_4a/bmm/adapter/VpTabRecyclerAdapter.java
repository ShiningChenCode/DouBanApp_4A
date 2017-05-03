package com.teamwork.doubanapp_4a.bmm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class VpTabRecyclerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles;
    private List<Fragment> fragments;

    public VpTabRecyclerAdapter(FragmentManager fm, String[] tabTitles, List<Fragment> fragments) {
        super(fm);
        this.tabTitles = tabTitles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return null == fragments ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return null == fragments ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

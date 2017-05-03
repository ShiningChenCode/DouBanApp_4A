package com.teamwork.doubanapp_4a.bmm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.VpTabRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BMMFragment extends BaseFragment {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] tabTitles;
    private TextView tvTitle;
    private List<Fragment> fragments;
    private VpTabRecyclerAdapter vpAdapter;

    public BMMFragment() {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_bmm;
    }

    @Override
    public void loadData() {
        tabTitles = getResources().getStringArray(R.array.bbm_tab_title);
        initFragments();
        initViewPager();
        setUpActionBar();
    }

    private void setUpActionBar() {
        getAppCompatActivity().setSupportActionBar(toolbar);
        getAppCompatActivity().getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvTitle.setText(getString(R.string.book_media_video));
    }

    private void initViewPager() {
        vpAdapter = new VpTabRecyclerAdapter(getChildFragmentManager(), tabTitles, fragments);
        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new MovieFragment());
        fragments.add(new BookFragment());
        fragments.add(new TVFragment());
        fragments.add(new CityFragment());
        fragments.add(new MusicFragment());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.tool_bar);
        toolbar.setTitle(getString(R.string.book_media_video));
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.book_media_video, menu);
    }
}

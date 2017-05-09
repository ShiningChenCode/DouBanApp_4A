package com.teamwork.doubanapp_4a.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.view.BMMFragment;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.broadcast.view.BroadcastFragment;
import com.teamwork.doubanapp_4a.broadcast.view.RecommentBroadcastFragment;
import com.teamwork.doubanapp_4a.group.view.GroupFragment;
import com.teamwork.doubanapp_4a.home.view.HomeFragment;
import com.teamwork.doubanapp_4a.mine.view.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, BroadcastFragment.OnChangeFragmentListener {
    LinearLayout llHome, llBMM, llBroadcast, llGroup, llMine;
    ImageView ivHome, ivBMM, ivBroadcast, ivGroup, ivMine;
    TextView tvHome, tvBMM, tvBroadcast, tvGroup, tvMine;

    ViewPager viewPager;
    FragmentStatePagerAdapter adapter;
    List<Fragment> mFragments;
    List<ImageView> mTabImageViews;
    List<TextView> mTabTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        bindListeners();

        initViewPager();

    }


    private void initViews() {
        llHome = (LinearLayout) findViewById(R.id.ll_home);
        llBMM = (LinearLayout) findViewById(R.id.ll_bmm);
        llBroadcast = (LinearLayout) findViewById(R.id.ll_broadcast);
        llGroup = (LinearLayout) findViewById(R.id.ll_group);
        llMine = (LinearLayout) findViewById(R.id.ll_mine);

        ivHome = (ImageView) findViewById(R.id.iv_home);
        ivBMM = (ImageView) findViewById(R.id.iv_bmm);
        ivBroadcast = (ImageView) findViewById(R.id.iv_broadcast);
        ivGroup = (ImageView) findViewById(R.id.iv_group);
        ivMine = (ImageView) findViewById(R.id.iv_mine);

        tvHome = (TextView) findViewById(R.id.tv_home);
        tvBMM = (TextView) findViewById(R.id.tv_bmm);
        tvBroadcast = (TextView) findViewById(R.id.tv_broadcast);
        tvGroup = (TextView) findViewById(R.id.tv_group);
        tvMine = (TextView) findViewById(R.id.tv_mine);

        ivHome.setSelected(true);
        tvHome.setTextColor(getResources().getColor(R.color.green_500));
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);

    }


    private void bindListeners() {
        llHome.setOnClickListener(this);
        llBMM.setOnClickListener(this);
        llBroadcast.setOnClickListener(this);
        llGroup.setOnClickListener(this);
        llMine.setOnClickListener(this);

    }


    private void initViewPager() {
        mTabImageViews = new ArrayList<>();
        mTabImageViews.add(ivHome);
        mTabImageViews.add(ivBMM);
        mTabImageViews.add(ivBroadcast);
        mTabImageViews.add(ivGroup);
        mTabImageViews.add(ivMine);

        mTabTextViews = new ArrayList<>();
        mTabTextViews.add(tvHome);
        mTabTextViews.add(tvBMM);
        mTabTextViews.add(tvBroadcast);
        mTabTextViews.add(tvGroup);
        mTabTextViews.add(tvMine);

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new BMMFragment());
        mFragments.add(new BroadcastFragment());
        mFragments.add(new GroupFragment());
        mFragments.add(new MineFragment());

        adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            private int mChildCount = 0;

            @Override
            public void notifyDataSetChanged() {
                mChildCount = getCount();
                super.notifyDataSetChanged();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(5);

    }

    /**
     * 清除Tab状态
     */
    private void clearTabStatus() {
        for (ImageView imageview : mTabImageViews
                ) {
            imageview.setSelected(false);

        }
        for (TextView textview : mTabTextViews) {
            textview.setTextColor(getResources().getColor(R.color.grey_500));
        }

    }

    @Override
    public void onClick(View v) {
        clearTabStatus();
        switch (v.getId()) {
            case R.id.ll_home:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.green_500));
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.ll_bmm:
                ivBMM.setSelected(true);
                tvBMM.setTextColor(getResources().getColor(R.color.green_500));
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.ll_broadcast:
                ivBroadcast.setSelected(true);
                tvBroadcast.setTextColor(getResources().getColor(R.color.green_500));
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.ll_group:
                ivGroup.setSelected(true);
                tvGroup.setTextColor(getResources().getColor(R.color.green_500));
                viewPager.setCurrentItem(3, false);
                break;
            case R.id.ll_mine:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.green_500));
                viewPager.setCurrentItem(4, false);
                break;

        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void changeToRecomentBroadcast() {
        LogUtil.d("changeToRecomentBroadcast", "changeToRecomentBroadcast");
        mFragments.add(2, new RecommentBroadcastFragment());
        mFragments.remove(3);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void changeToBroadcast() {
        mFragments.add(2, new BroadcastFragment());
        mFragments.remove(3);
        adapter.notifyDataSetChanged();
    }
}

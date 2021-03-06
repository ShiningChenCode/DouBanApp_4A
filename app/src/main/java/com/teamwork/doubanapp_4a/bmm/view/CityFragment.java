package com.teamwork.doubanapp_4a.bmm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.BooklRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.adapter.CityRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.bmm.presenter.MoviesPresenter;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;
import com.teamwork.doubanapp_4a.bmm.utils.FileUtil;
import com.teamwork.doubanapp_4a.bmm.view.base.ViewPagerRecylerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends ViewPagerRecylerFragment implements OnGetDataListener<MovieBean, MovieSuggestion> {
    private CityRecyclerAdapter recyclerAdapter;
    private MovieBean movieBean;
    private MovieSuggestion movieSuggestion;

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        presenter = new MoviesPresenter(mContext, this);
        presenter.getMovies();


    }


    @Override
    public void gettingData1() {
        loadingData();
    }

    @Override
    public void getData1Success(MovieBean data) {
        movieBean = data;
        presenter.getSuggestMovies();

    }

    @Override
    public void getData1Failed(String msg) {
        showFailed(msg);
    }

    @Override
    public void gettingData2() {

    }

    @Override
    public void getData2Success(MovieSuggestion data) {
        movieSuggestion = data;

        showData();
        recyclerAdapter = new CityRecyclerAdapter(movieBean.getModules(), movieSuggestion);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(getContext(), DensityUtil.dp2px(getContext(), 10),
                DensityUtil.dp2px(getContext(), 20), SpaceItemDecoration.TYPE_DIVIDER, R.color.grey_100));
    }

    @Override
    public void getData2Failed(String msg) {
        showFailed(msg);
    }
}

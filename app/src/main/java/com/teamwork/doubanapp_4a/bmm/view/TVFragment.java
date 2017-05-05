package com.teamwork.doubanapp_4a.bmm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.BooklRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.adapter.TVRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;
import com.teamwork.doubanapp_4a.bmm.utils.FileUtil;
import com.teamwork.doubanapp_4a.bmm.view.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private TVRecyclerAdapter recyclerAdapter;
    private MovieBean movieBean;
    private MovieSuggestion movieSuggestion;

    @Override
    public int getLayoutResId() {
        return R.layout.recycler_view;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        movieBean = new Gson().fromJson(FileUtil.readAssertResource(getActivity(), "movie.txt"), MovieBean.class);
        movieSuggestion = new Gson().fromJson(FileUtil.readAssertResource(getActivity(), "movie_suggestion.txt"), MovieSuggestion.class);
        recyclerAdapter = new TVRecyclerAdapter(movieBean.getModules(),movieSuggestion);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(getContext(), DensityUtil.dp2px(getContext(),10),DensityUtil.dp2px(getContext(),20),SpaceItemDecoration.TYPE_DIVIDER,R.color.grey_100));
//        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(getActivity(),10)));
    }
}

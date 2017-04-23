package com.teamwork.doubanapp_4a.bmm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.adapter.MovieRecyclerAdapter;
import com.teamwork.doubanapp_4a.bmm.adapter.SpaceItemDecoration;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.utils.DensityUtil;
import com.teamwork.doubanapp_4a.bmm.utils.FileUtil;
import com.teamwork.doubanapp_4a.bmm.view.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private MovieRecyclerAdapter recyclerAdapter;
    private MovieBean movieBean;

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
        recyclerView.setLayoutManager(  new LinearLayoutManager(getActivity()));
        movieBean = new Gson().fromJson(FileUtil.readAssertResource(getActivity(), "movie.txt"), MovieBean.class);
        recyclerAdapter = new MovieRecyclerAdapter(movieBean.getModules());
        recyclerView.setAdapter(recyclerAdapter);
//        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(getActivity(),10)));
    }
}

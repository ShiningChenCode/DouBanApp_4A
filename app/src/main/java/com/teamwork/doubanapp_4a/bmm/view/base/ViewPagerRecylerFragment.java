package com.teamwork.doubanapp_4a.bmm.view.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.bmm.presenter.MoviesPresenter;
import com.teamwork.doubanapp_4a.main.base.BaseFragment;

/**
 * Created by Iden on 2017/5/9.
 */

public class ViewPagerRecylerFragment extends BaseFragment {
    protected TextView tvFailed;
    protected ProgressBar progressBar;
    protected RecyclerView recyclerView;
    protected Context mContext;
    protected MoviesPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        mContext = getContext();

        recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        tvFailed = (TextView) view.findViewById(R.id.tv_failed);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public void showData() {
        tvFailed.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

    }

    public void loadingData() {
        tvFailed.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

    }

    public void showFailed(String msg) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        tvFailed.setVisibility(View.VISIBLE);
        tvFailed.setText(msg);
        tvFailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMovies();
            }
        });

    }



}

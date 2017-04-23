package com.teamwork.doubanapp_4a.bmm.view.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/4/23.
 */

public abstract class BaseFragment extends Fragment {
    public boolean isVisible;
    private boolean isPrepared;
    private AppCompatActivity appCompatActivity;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity = (AppCompatActivity) getActivity();
        setHasOptionsMenu(true);
        isPrepared = true;
        lazyLoad();
    }

    public AppCompatActivity getAppCompatActivity(){
        return this.appCompatActivity;
    }

    public abstract int getLayoutResId();

    public void onInvisible() {

    }

    public void onVisible() {
        lazyLoad();
    }

    public void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        loadData();
    }
    public abstract void loadData();
}

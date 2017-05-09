package com.teamwork.doubanapp_4a.bmm.presenter;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.bmm.bean.MovieBean;
import com.teamwork.doubanapp_4a.bmm.bean.MovieSuggestion;
import com.teamwork.doubanapp_4a.bmm.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.NetUtil;
import com.teamwork.doubanapp_4a.main.data.HttpURL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by Iden on 2017/5/6.
 */

public class MoviesPresenter {
    Context mContext;
    OnGetDataListener onGetDataListener;
    Handler mHandler = new Handler();

    public MoviesPresenter(Context mContext, OnGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
        this.mContext = mContext;

    }


    private boolean checkNetWrok() {
        if (!NetUtil.isNetworkAvailable(mContext)) {
            onGetDataListener.getData1Failed("请确认网络是否正常后点击刷新");
            return true;
        }
        return false;
    }


    public void getMovies() {
        if (checkNetWrok()) return;

        onGetDataListener.gettingData1();
        LogUtil.d("getMovies", "getMovies");
        OkHttpUtils.get().url(HttpURL.Movies).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getData1Failed("连接服务器失败！请稍后再试。");
                    }
                });
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d("getMovies", response);
                final MovieBean data = new Gson().fromJson(response, MovieBean.class);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getData1Success(data);

                    }
                });
            }
        });


    }


    public void getSuggestMovies() {

        if (checkNetWrok()) return;
        OkHttpUtils.get().url(HttpURL.SuggestMovies).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onGetDataListener.getData2Failed("连接服务器失败！请稍后再试。");
                    }
                });
            }

            @Override
            public void onResponse(String response, int id) {
                final MovieSuggestion data = new Gson().fromJson(response, MovieSuggestion.class);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getData2Success(data);

                    }
                });
            }
        });


    }


}

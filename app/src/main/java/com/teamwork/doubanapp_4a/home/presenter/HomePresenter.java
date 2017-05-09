package com.teamwork.doubanapp_4a.home.presenter;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.teamwork.doubanapp_4a.broadcast.utils.LogUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.NetUtil;
import com.teamwork.doubanapp_4a.home.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.home.model.BannerDatas;
import com.teamwork.doubanapp_4a.home.model.HomeDatas;
import com.teamwork.doubanapp_4a.main.data.HttpURL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by Iden on 2017/5/6.
 */

public class HomePresenter {
    Context mContext;
    OnGetDataListener onGetDataListener;
    Handler mHandler = new Handler();

    public HomePresenter(Context mContext, OnGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
        this.mContext = mContext;

    }


    private boolean checkNetWrok() {
        if (!NetUtil.isNetworkAvailable(mContext)) {
            onGetDataListener.getBannerFailed("请确认网络是否正常后点击刷新");
            return true;
        }
        return false;
    }


    public void getBanner() {
        if (checkNetWrok()) return;

        onGetDataListener.gettingBanner();
        OkHttpUtils.get().url(HttpURL.Banner).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getBannerFailed("连接服务器失败！请稍后再试。");
                    }
                });
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d("getMovies", response);
                final BannerDatas data = new Gson().fromJson(response, BannerDatas.class);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getBannerSuccess(data);

                    }
                });
            }
        });


    }


    public void getHomeDatas() {

        if (checkNetWrok()) return;
            onGetDataListener.gettingHomeDatas();
        OkHttpUtils.get().url(HttpURL.HomeDatas).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onGetDataListener.getHomeDatasFailed("连接服务器失败！请稍后再试。");
                    }
                });
            }

            @Override
            public void onResponse(String response, int id) {
                final HomeDatas data = new Gson().fromJson(response, HomeDatas.class);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getHomeDatasSuccess(data);

                    }
                });
            }
        });


    }


}

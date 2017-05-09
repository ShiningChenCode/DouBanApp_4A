package com.teamwork.doubanapp_4a.broadcast.presenter;

import android.content.Context;
import android.os.Handler;

import com.teamwork.doubanapp_4a.broadcast.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.utils.NetUtil;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.SqliteHelper;
import com.teamwork.doubanapp_4a.main.data.HttpURL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Iden on 2017/5/6.
 */

public class BroadcastPresenter {
    Context mContext;
    OnGetDataListener onGetDataListener;
    Handler mHandler = new Handler();

    public BroadcastPresenter(Context mContext, OnGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
        this.mContext = mContext;
        initDB();
    }

    /**
     * 本地数据库
     */
    private void initDB() {
        //实例化我们的DBHelper
        SqliteHelper dbHelper = new SqliteHelper(mContext);
        //调用了这个方法后，DBHelper中的onCreate才会执行
        dbHelper.getReadableDatabase();
    }


    private boolean checkNetWork() {
        if (!NetUtil.isNetworkAvailable(mContext)) {
            onGetDataListener.getDataFailed("请确认网络是否正常后点击刷新");
            return true;
        }
        return false;
    }


    /**
     * 获取广播列表
     *
     * @param flag 标记是否为下拉刷新
     *             1 为下拉刷新
     */
    public void getBroadcasts(final int flag) {
        if (checkNetWork()) return;
        if (flag != 1)
            onGetDataListener.gettingData();

        OkHttpUtils.get().url(HttpURL.Broadcasts).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (flag == 1) {
                            onGetDataListener.pullDownRefreshFailed("连接服务器失败！请稍后再试。");
                        } else {
                            onGetDataListener.getDataFailed("连接服务器失败！请稍后再试。");
                        }
                    }
                });
            }

            @Override
            public void onResponse(String response, int id) {
                //从本地数据库获取
                final List<Broadcast> data = new BroadcastDataHelper(mContext).getBroadcasts();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (flag == 1) {
                            onGetDataListener.pullDownRefreshSuccess(data);
                        } else {
                            onGetDataListener.getDataSuccess(data);
                        }


                    }
                });
            }
        });


    }


}

package com.teamwork.doubanapp_4a.broadcast.presenter;

import android.content.Context;
import android.os.Handler;

import com.teamwork.doubanapp_4a.broadcast.data.GetData;
import com.teamwork.doubanapp_4a.broadcast.interfaces.OnDataListener;
import com.teamwork.doubanapp_4a.broadcast.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.SqliteHelper;

import java.util.List;

/**
 * Created by Iden on 2017/5/6.
 */

public class BroadcastPresenter {
    Context mContext;
    OnGetDataListener onGetDataListener;
    Handler mHandler = new Handler();
    GetData getData = new GetData();

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

    public void getBroadcasts() {
        onGetDataListener.gettingData();

        getData.getBroadcsts(mContext, new OnDataListener<List<Broadcast>>() {
            @Override
            public void success(final List<Broadcast> data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.getDataSuccess(data);

                    }
                });
            }

            @Override
            public void failed() {

            }
        });


    }

    public void pullDownRefreshBroadcasts() {


        getData.getBroadcsts(mContext, new OnDataListener<List<Broadcast>>() {
            @Override
            public void success(final List<Broadcast> data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onGetDataListener.pullDownRefreshSuccess(data);

                    }
                });
            }

            @Override
            public void failed() {

            }
        });


    }

}

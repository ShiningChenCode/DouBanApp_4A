package com.teamwork.doubanapp_4a.broadcast.data;

import android.content.Context;

import com.teamwork.doubanapp_4a.broadcast.interfaces.IGetData;
import com.teamwork.doubanapp_4a.broadcast.interfaces.OnDataListener;
import com.teamwork.doubanapp_4a.broadcast.interfaces.OnGetDataListener;
import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iden on 2017/5/6.
 */

public class GetData implements IGetData {


    @Override
    public void getBroadcsts(final Context mContext, final OnDataListener<List<Broadcast>> onDataListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<Broadcast> mDatas = new ArrayList<>();
                mDatas = new BroadcastDataHelper(mContext).getBroadcasts();

                onDataListener.success(mDatas);


            }
        }).start();

    }


}

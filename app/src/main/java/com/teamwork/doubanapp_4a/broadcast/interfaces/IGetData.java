package com.teamwork.doubanapp_4a.broadcast.interfaces;

import android.content.Context;

import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;

import java.util.List;

/**
 * Created by Iden on 2017/5/6.
 */

public interface IGetData {

    void getBroadcsts(Context mContext, OnDataListener<List<Broadcast>> onDataListener);


}

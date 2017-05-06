package com.teamwork.doubanapp_4a.broadcast.interfaces;

/**
 * Created by Iden on 2017/5/6.
 */

public interface OnGetDataListener<T> {
    void gettingData();

    void getDataSuccess(T data);

    void getDataFailed();

    void refreshData();

    void pullDownRefreshData();

    void pullDownRefreshSuccess(T data);

    void pullDownRefreshFailed();

}

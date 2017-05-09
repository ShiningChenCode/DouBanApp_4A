package com.teamwork.doubanapp_4a.broadcast.interfaces;

import android.view.View;

/**
 * Created by Iden on 2017/5/6.
 */

public interface OnGetDataListener<T> {
    void gettingData();

    void getDataSuccess(T data);

    void getDataFailed(String msg);

    void refreshData();

    void pullDownRefreshData();

    void pullDownRefreshSuccess(T data);

    void pullDownRefreshFailed(String msg);


    void showData();

    void loadingData();

    void showFailed(String msg);

}

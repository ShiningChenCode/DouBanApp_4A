package com.teamwork.doubanapp_4a.broadcast.interfaces;

/**
 * Created by Iden on 2017/5/6.
 */

public interface OnDataListener<T> {

    void success(T data);

    void failed();
}

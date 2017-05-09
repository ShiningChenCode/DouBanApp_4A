package com.teamwork.doubanapp_4a.bmm.interfaces;

/**
 * 一个页面需要接收两个数据
 *
 * @param <T>
 * @param <E>
 */
public interface OnGetDataListener<T, E> {
    void gettingData1();

    void getData1Success(T data);

    void getData1Failed(String msg);

    void gettingData2();

    void getData2Success(E data);

    void getData2Failed(String msg);


}

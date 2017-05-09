package com.teamwork.doubanapp_4a.home.interfaces;

/**
 * @param <T>
 * @param <E>
 */
public interface OnGetDataListener<T, E> {
    void gettingBanner();

    void getBannerSuccess(T data);

    void getBannerFailed(String msg);

    void gettingHomeDatas();

    void getHomeDatasSuccess(E data);

    void getHomeDatasFailed(String msg);


}

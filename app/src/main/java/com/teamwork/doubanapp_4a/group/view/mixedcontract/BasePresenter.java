package com.teamwork.doubanapp_4a.group.view.mixedcontract;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BasePresenter<T,V> {
	public T mModel;
	public V mView;

	public void setMV(T model, V view) {
		mModel = model;
		mView = view;
	}
}

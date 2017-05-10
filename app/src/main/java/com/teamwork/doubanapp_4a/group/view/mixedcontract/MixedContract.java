package com.teamwork.doubanapp_4a.group.view.mixedcontract;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface MixedContract {
	 interface IFindMoreView<T>{
		void showMixedGroup(List<T> data);
		void showFailed();
	}
	 interface IFindMoreListener {
		void findMixedGroup(String url ,OnFindListener onFindListener);
	}
	 abstract  class Presenter extends BasePresenter<IFindMoreListener,IFindMoreView> {

		 public abstract void mixed(String url);
	}
}

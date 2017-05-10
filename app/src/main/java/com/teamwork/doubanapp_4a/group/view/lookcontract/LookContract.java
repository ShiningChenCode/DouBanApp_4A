package com.teamwork.doubanapp_4a.group.view.lookcontract;

import com.teamwork.doubanapp_4a.group.view.mixedcontract.BasePresenter;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.OnFindListener;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class LookContract {
	public interface ILookView<T>{
		void showLook(List<T> data);
		void showFailed();
		void showProgress();
		void hideProgress();
	}
	public interface ILookModel{
		void findLook(String url, OnFindListener onFindListener);
	}
	public static abstract class Presenter extends BasePresenter<ILookModel,ILookView>{
		public abstract void look(String url);
	}
}

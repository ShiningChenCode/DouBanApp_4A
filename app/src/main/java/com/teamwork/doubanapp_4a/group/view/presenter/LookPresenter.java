package com.teamwork.doubanapp_4a.group.view.presenter;

import com.teamwork.doubanapp_4a.group.view.lookcontract.Look;
import com.teamwork.doubanapp_4a.group.view.lookcontract.LookContract;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.OnFindListener;

import java.util.List;


/**
 * Created by Administrator on 2017/5/8.
 */

public class LookPresenter extends LookContract.Presenter {


	private android.os.Handler mHandler = new android.os.Handler();

	public LookPresenter(LookContract.ILookView iLookView) {
		setMV(new Look(), iLookView);
	}

	@Override
	public void look(String url) {

		mView.showProgress();

		mModel.findLook(url, new OnFindListener() {
			@Override
			public void findSucess(final List data) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						mView.showLook(data);
						mView.hideProgress();
					}
				});

			}

			@Override
			public void findFailed() {

			}
		});

	}
}

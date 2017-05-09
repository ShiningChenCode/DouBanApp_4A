package com.teamwork.doubanapp_4a.group.view.presenter;

import com.teamwork.doubanapp_4a.group.view.mixedcontract.Mixed;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.MixedContract;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.OnFindListener;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class MixedGroupPresenter extends MixedContract.Presenter {


	public MixedGroupPresenter(MixedContract.IFindMoreView iFindMoreView) {
		setMV(new Mixed(), iFindMoreView);
	}

	@Override
	public void mixed(String url) {
		mModel.findMixedGroup(url, new OnFindListener() {
			@Override
			public void findSucess(List data) {
				mView.showMixedGroup(data);
			}

			@Override
			public void findFailed() {

			}
		});

	}
}

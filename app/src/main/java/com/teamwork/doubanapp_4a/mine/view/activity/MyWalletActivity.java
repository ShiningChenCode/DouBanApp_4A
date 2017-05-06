package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;

public class MyWalletActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_wallet);
		initView();
	}
	public void initView(){
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mBaseTitle.setTitle("我的钱包");
		mBaseTitle.setTextTitle("优惠券");
		mBaseTitle.showText();
		mBaseTitle.setBtnBackGround(R.color.douban_white);
	}
}

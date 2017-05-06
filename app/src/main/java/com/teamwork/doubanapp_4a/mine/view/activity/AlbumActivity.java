package com.teamwork.doubanapp_4a.mine.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;

public class AlbumActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_album);
		initView();
	}
	public void initView(){
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mBaseTitle.setTitle("我的相册");
		mBaseTitle.setTextTitle("上传照片");
		mBaseTitle.showText();
		mBaseTitle.setBtnBackGround(R.color.douban_white);
	}
}

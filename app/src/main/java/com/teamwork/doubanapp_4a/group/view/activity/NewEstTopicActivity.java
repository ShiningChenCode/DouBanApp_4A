package com.teamwork.doubanapp_4a.group.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;

public class NewEstTopicActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_est_topic);
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mBaseTitle.setTitle("最新话题");
	}
}

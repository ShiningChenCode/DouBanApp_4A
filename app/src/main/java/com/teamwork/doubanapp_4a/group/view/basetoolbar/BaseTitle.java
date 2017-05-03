package com.teamwork.doubanapp_4a.group.view.basetoolbar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by Administrator on 2017/4/28.
 */

public class BaseTitle extends LinearLayout {

	private TextView titleText;
	private ImageView backImg;
	public BaseTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		View view = LayoutInflater.from(context).inflate(R.layout.fragment_gtoup_title,this,true);
		titleText = (TextView) view.findViewById(R.id.title_text);
		backImg = (ImageView) view.findViewById(R.id.back);
		backImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity)getContext()).finish();
			}
		});

	}

	public void setTitle(String s){
		titleText.setText(s);
	}

}

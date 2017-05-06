package com.teamwork.doubanapp_4a.group.view.basetoolbar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by Administrator on 2017/4/28.
 */

public class BaseTitle extends LinearLayout {

	private TextView titleText;
	private TextView functionText;
	private ImageView backImg;
	private Button functionBtn;
	public BaseTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		View view = LayoutInflater.from(context).inflate(R.layout.fragment_gtoup_title,this,true);
		titleText = (TextView) view.findViewById(R.id.title_text);
		functionText = (TextView) view.findViewById(R.id.functionText);
		backImg = (ImageView) view.findViewById(R.id.back);
		functionBtn = (Button) view.findViewById(R.id.fuctionBtn);
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
	public void showText(){
		functionText.setVisibility(VISIBLE);
	}
	public void hideText(){
		functionText.setVisibility(INVISIBLE);
	}
	public void showBtn(){
		functionBtn.setVisibility(VISIBLE);
	}
	public void setBtnBackGround(int res){
		functionBtn.setBackgroundResource(res);

	}


	public void setTextTitle(String s){
		functionText.setText(s);
	}

}

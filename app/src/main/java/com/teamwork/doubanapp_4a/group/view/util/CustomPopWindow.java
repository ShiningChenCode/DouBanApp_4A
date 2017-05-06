package com.teamwork.doubanapp_4a.group.view.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2017/3/8.
 */

public class CustomPopWindow extends PopupWindow {
	private View mContentView;
	public PopupWindow mPopupWindow;
	private int Width;
	private int Height;
	private Context mContext;
	private int mReslayoutId = -1;
	private int mAnmationStyle = -1;
	private boolean mIsFoucsable = true;
	private boolean mIsTouchable = true;
	private boolean mIsOutSideable = true;
	private String TAG = "kkk";

	private CustomPopWindow(Context mContext){
		this.mContext = mContext;
	}

	public CustomPopWindow showasDropDown(View v , int offsetx , int offsety){
		if (mPopupWindow!=null){
			mPopupWindow.showAsDropDown(v,offsetx,offsety);
		}
		return this;
	}
	public CustomPopWindow showasDropDown(View v){
		if (mPopupWindow!=null){
			mPopupWindow.showAsDropDown(v);
		}
		return this;
	}
	public CustomPopWindow showatDropDown(View v , int gravity ,int offsetx , int offsety){
		if (mPopupWindow!=null){
			mPopupWindow.showAsDropDown(v,gravity,offsetx,offsety);
		}
		return this;
	}
	public CustomPopWindow build(){
		if(mContentView == null){
			mContentView = LayoutInflater.from(mContext).inflate(mReslayoutId,null);
		}
		if (Width!=0 && Height!=0){
			mPopupWindow = new PopupWindow(mContentView,Width,Height);
		}
		else {
			Log.i("666", "build: " + ViewGroup.LayoutParams.MATCH_PARENT + ":" + ViewGroup.LayoutParams.MATCH_PARENT);
			mPopupWindow = new PopupWindow(mContentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		if (mAnmationStyle!=-1){
			mPopupWindow.setAnimationStyle(mAnmationStyle);
		}
		mPopupWindow.setFocusable(mIsFoucsable);
		mPopupWindow.setTouchable(mIsTouchable);
		mPopupWindow.setOutsideTouchable(mIsOutSideable);
		mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
		return this;
	}

	public static class PopWindowBulider{
		private CustomPopWindow mCustomPopWindow;

		public PopWindowBulider(Context mContext){
			mCustomPopWindow = new CustomPopWindow(mContext);
		}
		public PopWindowBulider setWidth(int width){
			mCustomPopWindow.Width = width;
			return this;
		}
		public PopWindowBulider setWHeight(int height){
			mCustomPopWindow.Height =height;
			return this;
		}
		public PopWindowBulider setView(View view){
			mCustomPopWindow.mContentView = view;
			mCustomPopWindow.mReslayoutId = -1;
			return this;
		}
		public PopWindowBulider setView(int reslayoutId){
			mCustomPopWindow.mContentView = null;
			mCustomPopWindow.mReslayoutId = reslayoutId;
			return this;
		}
		public PopWindowBulider setAnimation(int animation){
			mCustomPopWindow.mReslayoutId = animation;
			return this;
		}
		public CustomPopWindow creat(){
			return mCustomPopWindow.build();

		}

	}

}

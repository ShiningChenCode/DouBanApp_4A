package com.teamwork.doubanapp_4a.group.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.util.CustomPopWindow;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

	private WebView mWebView;
	private ImageView loadImg;
	private String url;
	private RelativeLayout titlelayout;
	private ImageView backImg;
	private ImageView overflow;
	private TextView title_text;
	private int titleheight;
	String TAG = "666";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		initView();
		initListener();
		Intent intent = getIntent();
		url = intent.getStringExtra("url");
		mWebView.loadUrl(url);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setBlockNetworkImage(false);
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return false;
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				Log.i(TAG, "onPageStarted: " + "---------------");
				Glide.with(DetailActivity.this).load(R.drawable.progress_view).asGif()
						.diskCacheStrategy(DiskCacheStrategy.NONE).into(loadImg);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				Log.i(TAG, "finish: " + "---------------");
				loadImg.setVisibility(View.GONE);
			}
		});
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onReceivedTitle(WebView view, String title) {
				super.onReceivedTitle(view, title);
				title_text.setText(title);
			}
		});
	}

	private void initView() {
		mWebView = (WebView) findViewById(R.id.webview);
		loadImg = (ImageView) findViewById(R.id.loadImg);
		backImg = (ImageView) findViewById(R.id.back);
		title_text = (TextView) findViewById(R.id.title_text);
		overflow = (ImageView) findViewById(R.id.overflow);
		titlelayout = (RelativeLayout) findViewById(R.id.titlelayout);
	}

	private void initListener() {
		backImg.setOnClickListener(this);
		overflow.setOnClickListener(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		titleheight = titlelayout.getHeight();
		Log.i(TAG, "onWindowFocusChanged: " + titleheight);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.back:
				if (mWebView.canGoBack()) {
					mWebView.goBack();
				}else {
					finish();
				}
				break;
			case R.id.overflow:
				CustomPopWindow customPopWindow = new CustomPopWindow.PopWindowBulider(this).setView(R
						.layout.fragment_group_overflow_item).setWidth(WindowManager.LayoutParams
						.WRAP_CONTENT).setWHeight(WindowManager.LayoutParams.WRAP_CONTENT).creat();
				customPopWindow.showasDropDown(v,0,-titleheight/2);
				break;
		}
	}
}

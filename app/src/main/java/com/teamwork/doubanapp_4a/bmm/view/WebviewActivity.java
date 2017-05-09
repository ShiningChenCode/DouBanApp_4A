package com.teamwork.doubanapp_4a.bmm.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

public class WebviewActivity extends Activity implements View.OnClickListener {
    Context mContext;
    Toolbar toolbar;
    ImageView ivBarBack;
    WebView webView;
    String url = "https://www.baidu.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_webview);
        initViews();
        ivBarBack.setOnClickListener(this);
        url = getIntent().getExtras().getString("url");
        webView.loadUrl(url);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ivBarBack = (ImageView) findViewById(R.id.iv_bar_back);
        webView = (WebView) findViewById(R.id.webview);
        initWebView();


    }

    private void initWebView() {
        //声明WebSettings子类
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_bar_back:

                ((Activity) mContext).finish();
                break;

        }

    }

}

package com.teamwork.doubanapp_4a.broadcast.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.BroadcastDataHelper;
import com.teamwork.doubanapp_4a.broadcast.utils.dbutils.IntentUtil;
import com.teamwork.doubanapp_4a.main.MainActivity;
import com.teamwork.doubanapp_4a.utils.ToastUtil;

public class SendBroadcastActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    Toolbar toolbar;
    ImageView ivBarBack, ivSend;
    TextView tvTextCount, tvTextCountTotal;
    EditText etBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast);
        mContext = this;
        initViews();

        setSupportActionBar(toolbar);

        bindListeners();


    }


    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ivBarBack = (ImageView) findViewById(R.id.iv_bar_back);
        ivSend = (ImageView) findViewById(R.id.iv_send);

        tvTextCount = (TextView) findViewById(R.id.tv_text_count);
        tvTextCountTotal = (TextView) findViewById(R.id.tv_text_count_total);

        etBroadcast = (EditText) findViewById(R.id.et_broadcast);


    }


    private void bindListeners() {
        ivBarBack.setOnClickListener(this);
        ivSend.setOnClickListener(this);

        etBroadcast.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvTextCount.setText(String.valueOf(s.length()));
                if (count > 140) {
                    tvTextCount.setTextColor(getResources().getColor(R.color.red_900));
                    tvTextCountTotal.setTextColor(getResources().getColor(R.color.red_900));
                } else {
                    tvTextCount.setTextColor(getResources().getColor(R.color.grey_500));
                    tvTextCountTotal.setTextColor(getResources().getColor(R.color.grey_500));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_bar_back:
                ToastUtil.showShort(mContext, "取消发送");
                ((Activity) mContext).finish();
                break;
            case R.id.iv_send:
                ToastUtil.showShort(mContext, "发送");
                new BroadcastDataHelper(mContext).sendBroadcast(1, etBroadcast.getText().toString());
                ((Activity) mContext).finish();
                break;

        }

    }
}

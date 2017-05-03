package com.teamwork.doubanapp_4a.group.view.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.basetoolbar.BaseTitle;
import com.teamwork.doubanapp_4a.group.view.db.MySqlite;

public class RecentlyBrowseActivity extends AppCompatActivity {

	private BaseTitle mBaseTitle;
	private MySqlite mMySqlite;
	private SQLiteDatabase mSQLiteDatabase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recently_browse);
		mBaseTitle = (BaseTitle) findViewById(R.id.basetitle);
		mBaseTitle.setTitle("最近浏览");
		mMySqlite = new MySqlite(this,"Group.db",null,1);
		mSQLiteDatabase = mMySqlite.getWritableDatabase();
	}
}

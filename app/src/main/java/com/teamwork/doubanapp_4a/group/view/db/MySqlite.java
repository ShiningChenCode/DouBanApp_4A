package com.teamwork.doubanapp_4a.group.view.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/4/27.
 */

public class MySqlite extends SQLiteOpenHelper {

	public final static String table_name = "often";
	public final static String Img_url = "Img_url";
	public final static String Title_text = "Title_text";
	public final static String Detail_url = "Detail_url";

	public final static String table1_name = "browse";
	public final static String Img1_url = "Img_url";
	public final static String Title1_text = "Title_text";
	public final static String Detail1_url = "Detail_url";

	public MySqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int
			version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table " + table_name + "(" + "id integer primary key autoincrement, " + Img_url
				     + " text, " + Title_text + " text, " + Detail_url + " text" + ")";
		String sql1 = "create table " + table1_name + "(" + "id integer primary key autoincrement, " + Img1_url
				+ " text, " + Title1_text + " text, " + Detail1_url + " text" + ")";
		db.execSQL(sql);
		db.execSQL(sql1);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}

package com.teamwork.doubanapp_4a.broadcast.utils.dbutils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.teamwork.doubanapp_4a.broadcast.model.Broadcast;
import com.teamwork.doubanapp_4a.broadcast.model.Comment;
import com.teamwork.doubanapp_4a.broadcast.model.Like;
import com.teamwork.doubanapp_4a.broadcast.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作广播数据
 */

public class BroadcastDataHelper {

    private SQLiteDatabase db;
    private SqliteHelper dbHelper;

    public BroadcastDataHelper(Context context) {
        dbHelper = new SqliteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void Close() {
        db.close();
        dbHelper.close();
    }


    public List<Broadcast> getBroadcasts() {
        List<Broadcast> broadcasts = new ArrayList<Broadcast>();

        Cursor cursor = db.query("Broadcast", null, null, null, null, null, "time desc" );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Broadcast broadcast = new Broadcast();
            broadcast.setId(cursor.getInt(cursor.getColumnIndex("_ID")));
            broadcast.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
            broadcast.setContent(cursor.getString(cursor.getColumnIndex("content")));
            broadcast.setTime(cursor.getLong(cursor.getColumnIndex("time")));

            broadcasts.add(broadcast);
            cursor.moveToNext();
        }
        cursor.close();
        return broadcasts;
    }

    public List<Comment> getComments(int broadcsat_id) {
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = db.query("Comment", null, "broadcast_id= '" + broadcsat_id + "'", null, null, null, "time");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = new Comment();
            comment.setId(cursor.getInt(cursor.getColumnIndex("_ID")));
            comment.setBroadcast_id(cursor.getInt(cursor.getColumnIndex("broadcast_id")));
            comment.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
            comment.setContent(cursor.getString(cursor.getColumnIndex("content")));
            comment.setTime(cursor.getLong(cursor.getColumnIndex("time")));

            comments.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return comments;
    }


    public List<Like> getLikes(int broadcsat_id) {
        List<Like> likes = new ArrayList<Like>();

        Cursor cursor = db.query("Like", null, "broadcast_id= '" + broadcsat_id + "'", null, null, null, "time");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Like like = new Like();
            like.setId(cursor.getInt(cursor.getColumnIndex("_ID")));
            like.setBroadcast_id(cursor.getInt(cursor.getColumnIndex("broadcast_id")));
            like.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
            like.setTime(cursor.getLong(cursor.getColumnIndex("time")));

            likes.add(like);
            cursor.moveToNext();
        }
        cursor.close();
        return likes;
    }


    public User getUser(int id) {
        User user = new User();
        Cursor cursor = db.query("User", null, "_id='" + id + "'", null, null, null, null);
        cursor.moveToFirst();
        user.setId(cursor.getInt(cursor.getColumnIndex("_ID")));
        user.setIcon_url(cursor.getString(cursor.getColumnIndex("icon_url")));
        user.setName(cursor.getString(cursor.getColumnIndex("name")));
        cursor.close();

        return user;

    }

    public void setLike(int broadcsat_id, int user_id) {
        db.execSQL("INSERT INTO Like(broadcast_id,user_id,time) VALUES('" + broadcsat_id + "', '" + user_id + "', '" + System.currentTimeMillis() + "')");

    }


    public void sendBroadcast(int user_id, String content) {
        db.execSQL("INSERT INTO Broadcast(user_id,content,time) VALUES('" + user_id + "','" + content + "','" + System.currentTimeMillis() + "')");

    }

}

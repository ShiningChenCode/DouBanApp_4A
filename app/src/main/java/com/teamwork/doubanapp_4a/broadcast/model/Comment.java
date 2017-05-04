package com.teamwork.doubanapp_4a.broadcast.model;

/**
 * 回应
 */

public class Comment {
    int id;
    int broadcast_id;
    int user_id;
    String content;
    long time;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBroadcast_id() {
        return broadcast_id;
    }

    public void setBroadcast_id(int broadcast_id) {
        this.broadcast_id = broadcast_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

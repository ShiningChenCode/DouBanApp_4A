package com.teamwork.doubanapp_4a.broadcast.model;

/**
 * 赞
 */

public class Like {
    int id;
    int broadcast_id;
    int user_id;
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


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

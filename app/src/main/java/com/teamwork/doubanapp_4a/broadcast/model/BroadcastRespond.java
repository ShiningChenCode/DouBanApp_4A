package com.teamwork.doubanapp_4a.broadcast.model;

/**
 * Created by Iden on 2017/4/23.
 */

public class BroadcastRespond {
    User user;
    long time;
    String content;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

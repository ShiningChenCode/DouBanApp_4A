package com.teamwork.doubanapp_4a.broadcast.model;

/**
 * 豆瓣用户信息
 */

public class User {

    int icon;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


}

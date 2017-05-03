package com.teamwork.doubanapp_4a.broadcast.model;

/**
 * 广播内容
 */

public class BroadcastContent {
    User user;
    long   time;
    String type;
    RelayContent relayContent;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RelayContent getRelayContent() {
        return relayContent;
    }

    public void setRelayContent(RelayContent relayContent) {
        this.relayContent = relayContent;
    }
}

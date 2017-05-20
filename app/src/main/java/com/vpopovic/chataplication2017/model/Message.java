package com.vpopovic.chataplication2017.model;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alen on 13-May-17.
 */

public class Message extends BaseModel implements Serializable, Comparable<Message> {

    private String text;

    private Date timestamp;

    private User user;


    public Message() {
    }

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        this.timestamp = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public int compareTo(@NonNull Message o) {
        return timestamp.compareTo(o.getTimestamp());
    }
}

package com.vpopovic.chataplication2017.model;

/**
 * Created by Alen on 07-May-17.
 */

public class Conversation extends BaseModel {

    private String title;

    public Conversation(String id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

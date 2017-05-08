package com.vpopovic.chataplication2017.model;

/**
 * Created by Alen on 07-May-17.
 */

public class BaseModel {

    private String id;

    public BaseModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
